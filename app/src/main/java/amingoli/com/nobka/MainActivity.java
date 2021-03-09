package amingoli.com.nobka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentOne.SendMessage{
    private FragmentManager fragmentManagers = getSupportFragmentManager();

    private Fragment a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        a = new FragmentOne();
        b = new FragmentTwo();
        loadFragment(R.id.frame_a,a);
        loadFragment(R.id.frame_b,b);
    }


    private void loadFragment(int id, Fragment fragment) {
        if (fragment != null) {
            fragmentManagers.beginTransaction()
                    .replace(id, fragment)
                    .commit();
        }
    }

    @Override
    public void sendData(String message) {
        FragmentTwo f = (FragmentTwo) b;
        if (f != null) {
            f.displayReceivedData(message);
        }
    }
}