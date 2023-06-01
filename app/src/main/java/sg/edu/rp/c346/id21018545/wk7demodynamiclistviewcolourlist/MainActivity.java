package sg.edu.rp.c346.id21018545.wk7demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etPosition;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etPosition = findViewById(R.id.editTextPosition);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String newColor = etElement.getText().toString();
                int position = Integer.parseInt(etPosition.getText().toString());
                alColours.add(position-1, newColor);
                aaColour.notifyDataSetChanged();
                etElement.setText(null);
                etPosition.setText(null);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int position = Integer.parseInt(etPosition.getText().toString());
                alColours.remove(position-1);
                aaColour.notifyDataSetChanged();
                etElement.setText(null);
                etPosition.setText(null);


            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String newColor = etElement.getText().toString();
                int position = Integer.parseInt(etPosition.getText().toString());
                alColours.set(position-1, newColor);
                aaColour.notifyDataSetChanged();
                etElement.setText(null);
                etPosition.setText(null);

            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected= "You selected " + alColours.get(position);
                Toast.makeText(MainActivity.this, itemSelected, Toast.LENGTH_SHORT).show();
                aaColour.notifyDataSetChanged();
            }

        });


    }
}