package vuchris.tacoma.uw.edu.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity implements ButtonsFragment.InstructionInteractionListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Create new buttons for showing instructions and starting the game
         */
        Button instructionsButton = (Button)findViewById(R.id.instructions_button);
        Button startButton = (Button)findViewById(R.id.start_game) ;

        /**
         * setOnClickListener for instructions and start button
         */
        instructionsButton.setOnClickListener(this);
        startButton.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * takes user to instructions page
     */
    private void instructionButtonClick()
    {
        startActivity(new Intent("vuchris.tacoma.uw.edu.homepage.InstructionsActivity"));
    }

    private void startButtonClick()
    {
        startActivity(new Intent("vuchris.tacoma.uw.edu.homepage.DifficultyLevelActivity"));
    }

    /**
     * When clicked upon, either instructions button or start button will be activated.
     * Instructions button takes user to instructions page.
     * Start button takes user to difficulty level portion of the game.
     * @param v view where user sees
     */
    @Override
    public void onClick (View v)
    {
        switch (v.getId())
        {
            case R.id.instructions_button:
                instructionButtonClick();
                break;

            case R.id.start_game:
                startButtonClick();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
