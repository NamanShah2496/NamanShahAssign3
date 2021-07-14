package naman.shah.n01392496.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    public static ShahFragment newInstance() {
        return new ShahFragment();
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
        final TextView textView = v.findViewById(R.id.section_label);

        pageViewModel.getText().observe(getViewLifecycleOwner(),
                new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                       // textView.setText("Naman Shah, N01392496");
                    }
                });
        // Inflate the layout for this fragment
        return v;
    }
}