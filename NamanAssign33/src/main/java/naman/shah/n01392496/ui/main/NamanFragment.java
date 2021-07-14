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
    int[] images = {R.drawable.cv,R.drawable.fn,R.drawable.wpl};
    int i = 0;
    ImageButton imageButton;
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
        configureImageButton();

        return v;
    }


    private void configureImageButton() {
        // TODO Auto-generated method stub
        ImageButton btn = (ImageButton) v.findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imageButton.setImageResource(images[i]);
                i++;
                if(i==3)
                    i=0;
            }
        });


    }

}
