package idat.com.bar_android;

import static idat.com.bar_android.R.drawable.background_update_order_dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

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


public class UpdateOrderDialogFragment extends DialogFragment {

    ImageView closeButton, takePhotoButton, defaultPhoto;
    Button  updateButton, cancelButton;
    TextInputEditText fecha_entrega, estado;
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
        cancelButton = root.findViewById(R.id.update_order_button_cancel);



        eventCloseDialog();

        return createUpdateOrderDialog();
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }



    /*DE AQUÍ EN ADELANTE SON MÉTODOS CUSTOM*/

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