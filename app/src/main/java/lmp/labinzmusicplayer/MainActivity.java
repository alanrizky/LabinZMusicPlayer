package lmp.labinzmusicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import lmp.labinzmusicplayer.fragments.ArtistSongFragment;
import lmp.labinzmusicplayer.fragments.LibraryFragment;
import lmp.labinzmusicplayer.fragments.PlayerActivityFragment;
import lmp.labinzmusicplayer.fragments.SearchFragment;
import lmp.labinzmusicplayer.fragments.SettingFragment;
import lmp.labinzmusicplayer.fragments.SongListFragment;

public class MainActivity extends AppCompatActivity implements
        SongListFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener,
        LibraryFragment.OnFragmentInteractionListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        ArtistSongFragment.OnFragmentInteractionListener,
        PlayerActivityFragment.OnFragmentInteractionListener,
        SettingFragment.OnFragmentInteractionListener {


    private SettingFragment settingFragment;
    private SongListFragment songListFragment;
    private ArtistSongFragment artistSongFragment;
    private PlayerActivityFragment playerActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        songListFragment = new SongListFragment();
        artistSongFragment = new ArtistSongFragment();
        playerActivityFragment = new PlayerActivityFragment();
        settingFragment = new SettingFragment();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, songListFragment)
                .commit();
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_song_list:
                fragment = new SongListFragment();
                break;
            case R.id.action_search:
                fragment = new SearchFragment();
                break;
            case R.id.action_library:
                fragment = new LibraryFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onSongListFragmentClicked(View view) {
        FragmentTransaction f = getSupportFragmentManager().beginTransaction();
        f.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
        f.replace(R.id.fragment_container, artistSongFragment);
        f.commit();
    }

    @Override
    public void onFileNameFragmentClicked(View view) {
        FragmentTransaction f = getSupportFragmentManager().beginTransaction();
        f.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
        f.replace(R.id.fragment_container, playerActivityFragment);
        f.commit();
    }

    @Override
    public void onBackClicked(View view) {
        FragmentTransaction f = getSupportFragmentManager().beginTransaction();
        f.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
        f.replace(R.id.fragment_container, artistSongFragment);
        f.commit();
    }

    @Override
    public void onSettingFragmentClicked(View view) {
        FragmentTransaction f = getSupportFragmentManager().beginTransaction();
        f.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_from_left,R.anim.enter_from_left,R.anim.exit_from_right);
        f.replace(R.id.fragment_container, settingFragment);
        f.commit();
    }
}
