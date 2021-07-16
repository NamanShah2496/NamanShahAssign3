package naman.shah.n01392496.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import naman.shah.n01392496.CanvasView;
import naman.shah.n01392496.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShahFragment extends Fragment {
    private static final String TAG ="2";
    private PageViewModel pageViewModel;
    private View v;
    Button clear,update;
    Spinner size;
    Spinner color;
    private CanvasView customCanvas;

    public static ShahFragment newInstance() {
        return new ShahFragment();
    }
    public void clearCanvas(View view){
        customCanvas.clearPath();
    }
    public void updatePen(View v){
        String penSize = (String)((TextView)size.getSelectedView()).getText();
        String penColor = (String)((TextView)color.getSelectedView()).getText();
        penColor.toUpperCase();
        customCanvas.updateCanvas(penSize,penColor);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_shah, container, false);
        customCanvas = (CanvasView) v.findViewById(R.id.signature_canvas);
        clear = v.findViewById(R.id.namanclearbutton);
        update = v.findViewById(R.id.namanupdatebutton);
        size = (Spinner)v.findViewById(R.id.namanthickspinner);
        color = (Spinner)v.findViewById(R.id.namancolorspinner);
        final TextView textView = v.findViewById(R.id.section_label);

        pageViewModel.getText().observe(getViewLifecycleOwner(),
                new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                        textView.setText(R.string.name_id);
                    }
                });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePen(v);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCanvas(v);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}