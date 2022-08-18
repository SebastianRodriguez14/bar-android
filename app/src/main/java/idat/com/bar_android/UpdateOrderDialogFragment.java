package idat.com.bar_android;

import static android.app.Activity.RESULT_OK;
import static idat.com.bar_android.R.drawable.background_update_order_dialog;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DateIntervalFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import idat.com.bar_android.models.ListOrdersModel;
import idat.com.bar_android.models.OrderStaticDetils;


public class UpdateOrderDialogFragment extends DialogFragment {

    private static final int PERMISSION_CODE = 1200;
    private static final int CAPTURE_CODE = 1000;
    ImageView closeButton, takePhotoButton, defaultPhoto;
    Button  updateButton, cancelButton;
    TextInputEditText telefono, dni, fecha_entrega, estado;
    Uri imageUri;
    View root;

    public UpdateOrderDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        root = inflater.inflate(R.layout.fragment_update_order_dialog, null);
        eventCloseDialog();
        saveUpdateOrder();
        cancelUpdateOrder();
        setDefaultsValues();
        uploadImage();

        return createUpdateOrderDialog();
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }



    /*DE AQUÍ EN ADELANTE SON MÉTODOS CUSTOM*/


    //Set defaults values for the dialog
    private void setDefaultsValues(){
        telefono = root.findViewById(R.id.update_order_telefono);
        dni = root.findViewById(R.id.update_order_dni_recoger);
        fecha_entrega = root.findViewById(R.id.update_order_fecha_entrega);
        estado = root.findViewById(R.id.update_order_estado);


        telefono.setText(OrderStaticDetils.getOrderModel().getCliente().getTelefono());
        dni.setText(OrderStaticDetils.getOrderModel().getDni_recibidor());
        fecha_entrega.setText(new SimpleDateFormat("dd/MM/yy").format(OrderStaticDetils.getOrderModel().getFecha_envio()));
        estado.setText(OrderStaticDetils.getOrderModel().getEstado().getNombre());
    }


    // Para abrirlo como un diálogo
    public Dialog createUpdateOrderDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.UpdateOrderDialog);
        builder.setView(root);
        showCalendarInDateOrder();
        showStatesForOrderInInput();
        return builder.create();
    }

    // Evento de cerrar el diálogo
    public void eventCloseDialog(){
        closeButton = root.findViewById(R.id.update_dialog_close);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void saveUpdateOrder(){
        updateButton = root.findViewById(R.id.update_order_button_update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrdersOptionsActivity.class);
                startActivity(intent);
            }
        });
    }



    public void cancelUpdateOrder(){
        cancelButton = root.findViewById(R.id.update_order_button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void uploadImage(){
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        defaultPhoto = root.findViewById(R.id.update_order_upload_image);
        takePhotoButton = root.findViewById(R.id.update_order_upload_image);
        takePhotoButton.setOnClickListener(v -> {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(activity.checkSelfPermission(Manifest.permission.CAMERA) ==
                        PackageManager.PERMISSION_DENIED ||
                        activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                PackageManager.PERMISSION_DENIED){
                    String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    requestPermissions(permission, PERMISSION_CODE);
                }
                else {
                    openCamera();
                }
            }
            else {
                openCamera();
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            defaultPhoto.setImageURI(imageUri);
        }
    }

    private void openCamera() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        imageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, CAPTURE_CODE);
    }


    // Para mostrar los campos llenos
    public void setDefaultValues(){
    }

    // Método para trabajar el calendario al darle clic en fecha entrega
    public void showCalendarInDateOrder(){
        fecha_entrega = root.findViewById(R.id.update_order_fecha_entrega);
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateCalendar();
            }
            private void updateCalendar(){
                String format = "dd/MM/yy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
                fecha_entrega.setText(simpleDateFormat.format(calendar.getTime()));


            }
        };

        fecha_entrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    public void showStatesForOrderInInput(){
        estado = root.findViewById(R.id.update_order_estado);
        String[] itemsEstado = new String[] {"Pendiente", "Postergado", "Entregado", "Anulado"};
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Elige un estado");
                builder.setSingleChoiceItems(itemsEstado, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        estado.setText(itemsEstado[which]);
                        dialog.dismiss();
                    }
                });
                builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder
                        .create()
                        .show();

            }
        });
    }




}