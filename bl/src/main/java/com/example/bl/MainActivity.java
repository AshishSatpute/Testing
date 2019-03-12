package com.example.bl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_ENABLE_BT = 12;
    private TextView out, tv;
    private BluetoothAdapter adapter;
    Button btn;

    BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        out = (TextView) findViewById(R.id.tvBluetoothInfo);
        setBluetoothData();

        if (Connections.blueTooth()) {
            Intent enableBtIntent = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Discovery", "Started");

                tv.setText("Searching Available Devices...");

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        out.setText("");
        setBluetoothData();
    }

    private void setBluetoothData() {

        // Getting the Bluetooth adapter
        adapter = BluetoothAdapter.getDefaultAdapter();
        out.append("\nAdapter: " + adapter.toString() + "\n\nName: "
                + adapter.getName() + "\nAddress: " + adapter.getAddress());

        // Check for Bluetooth support in the first place
        // Emulator doesn't support Bluetooth and will return null

        if (adapter == null) {
            Toast.makeText(this, "Bluetooth NOT supported. Aborting.",
                    Toast.LENGTH_LONG).show();
        }

        // Starting the device discovery
        out.append("\n\nStarting discovery...");
        adapter.startDiscovery();
        out.append("\nDone with discovery...\n");

        // Listing paired devices
        out.append("\nDevices Pared:");
        Set<BluetoothDevice> devices = adapter.getBondedDevices();
        for (BluetoothDevice device : devices) {
            out.append("\nFound device: " + device.getName() + " Add: "
                    + device.getAddress());
        }

        find();
    }


    public void find() {
        adapter.startDiscovery();
        mReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();

                //Finding devices
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    // Get the BluetoothDevice object from the Intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    // Add the name and address to an array adapter to show in a ListView
                    //mArrayAdapter.add(device.getName() + "\n" + device.getAddress());

                    Toast.makeText(context, "Devi", Toast.LENGTH_SHORT).show();
                    Log.i("www", "onReceive: " + device.getName() + "\n" + device.getAddress());
                }
            }
        };

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
    }



}
