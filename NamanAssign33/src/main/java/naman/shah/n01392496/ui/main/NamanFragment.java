package naman.shah.n01392496.ui.main;
// Naman Shah, N01392496, RNA
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import naman.shah.n01392496.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class NamanFragment extends Fragment {
    private static final String TAG = "1";
    private View v;
    private PageViewModel pageViewModel;

    public static NamanFragment newInstance() {

        return new NamanFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_naman, container, false);
        final TextView textView = v.findViewById(R.id.section_label);
        pageViewModel.getText().observe(getViewLifecycleOwner(),
                new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });


        final ImageButton btn = (ImageButton) v.findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                if (count > 2) {
                    count = 0;

                }
                if (count == 0){
                    btn.setImageResource(R.drawable.fn);
                }
                if (count == 1) {
                    btn.setImageResource(R.drawable.three);
                }
                if (count == 2){
                    btn.setImageResource(R.drawable.one);
                }
                 count++;
            }
        });
    return v;}
}


