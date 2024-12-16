package com.luv.cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SelectFavoriteTeam extends AppCompatActivity {

    Button back, australia, india, westIndies, england, pakistan, sriLanka, southAfrica, newZealand, zimbabwe, afganistan, bangladesh, ireland, nambia, unitedArabEmirates, scotland, canada, kenya, papuaNewGuinea, nepal, unitedStates, netherlands, qatar, wales, hongKong;

    TextView selectTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_favorite_team);

        selectTeam = findViewById(R.id.selectTeam);
        back = findViewById(R.id.back);
        australia = findViewById(R.id.australia);
        india = findViewById(R.id.india);
        westIndies = findViewById(R.id.westIndies);
        england = findViewById(R.id.england);
        pakistan = findViewById(R.id.pakistan);
        sriLanka = findViewById(R.id.sriLanks);
        southAfrica = findViewById(R.id.southAfrica);
        newZealand = findViewById(R.id.newZealand);
        zimbabwe = findViewById(R.id.zimbabwe);
        afganistan = findViewById(R.id.afganistan);
        bangladesh = findViewById(R.id.bangladesh);
        ireland = findViewById(R.id.ireland);
        nambia = findViewById(R.id.nambia);
        unitedArabEmirates = findViewById(R.id.unitedArabEmirates);
        scotland = findViewById(R.id.scotland);
        canada = findViewById(R.id.canada);
        kenya = findViewById(R.id.kenya);
        papuaNewGuinea = findViewById(R.id.papuaNewGuinea);
        nepal = findViewById(R.id.nepal);
        unitedStates = findViewById(R.id.unitedStates);
        netherlands = findViewById(R.id.netherlands);
        qatar = findViewById(R.id.qatar);
        wales = findViewById(R.id.wales);
        hongKong = findViewById(R.id.hongKong);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                startActivity(intent);
            }
        });

        australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", australia.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Australia is your favorite Country", Toast.LENGTH_SHORT).show();
                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", india.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"India is your favorite Country", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
                builder.create().show();
            }
        });

        westIndies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", westIndies.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"West Indies is your favorite Country", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
                builder.create().show();
            }
        });
        england.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", england.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"England is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        pakistan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", pakistan.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Pakistan is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        sriLanka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", sriLanka.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Sri Lanka is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        southAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", southAfrica.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"South Africa is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        newZealand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", newZealand.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"New Zealand is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        zimbabwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", zimbabwe.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Zimbabwe is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        afganistan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", afganistan.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Afganistan is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        bangladesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", bangladesh.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Bangladesh is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        ireland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", ireland.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Ireland is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        nambia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", nambia.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Nambia is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        unitedArabEmirates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", unitedArabEmirates.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"United Arab Emirates is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        scotland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", scotland.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Scotland is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        canada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", canada.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Canada is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        kenya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", kenya.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Kenya is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        papuaNewGuinea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", papuaNewGuinea.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Papua New Guinea is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        nepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", nepal.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Nepal is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        unitedStates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", unitedStates.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"United States is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        netherlands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", netherlands.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Netherlands is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        qatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", qatar.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Qatar is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        wales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", wales.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Wales is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
        hongKong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] options = {"Yes","No"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                builder.setTitle("Do you want to select this team as your favourite?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        if (which == 0 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, MainActivity.class);
                            intent.putExtra("country", hongKong.getText().toString());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(SelectFavoriteTeam.this,"Hong Kong is your favorite Country", Toast.LENGTH_SHORT).show();

                        }
                        if (which == 1 ){

                            Intent intent = new Intent(SelectFavoriteTeam.this, SelectFavoriteTeam.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }

                    }
                });
                builder.create().show();
            }
        });
    }

}
