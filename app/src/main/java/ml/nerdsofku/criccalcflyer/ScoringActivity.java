package ml.nerdsofku.criccalcflyer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ScoringActivity extends AppCompatActivity {

    private TextView scoreMain,target,runReq,extraRun,totalOv,ovRem,overDone,crr,rrr;
    private TextView batman1,batman1_run,batman1_ball,batman1_4s,batman1_6s,batman1_sr,batman2,batman2_run,batman2_ball,batman2_4s,batman2_6s,batman2_sr,ballman,ballman_over,ballman_run,ballman_wicket,ballman_maiden,ballman_eco;
    private LinearLayout batManMenu,ballManMenu;
    private Button r0,r1,r2,r3,r4,r5,r6,r7,wd,nb,bye,lbye,wicket,undo,redo,copyToCb;

    private String opTeam;
    private boolean isBatting;
    private int totalOver, targetRun, ings;
    private ScoringHandler sh;
    private int runOnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        extractJson();
        if(isBatting) sh = new BattingHandler(totalOver,targetRun);
        else sh = new BowlingHandler(totalOver,targetRun,this);
        setupViews();
        setupBtnOnClick();
        updateViews();

    }

    private void updateViews() {
        setScore();
        setExtra();
        setRRR();
        setRunReq();
        setOv();
        setOvRem();
        setTarget();
        setTotalOv();
        setCRR();
    }

    private void extractJson() {
        try {
            JSONObject setup = new JSONObject(getIntent().getStringExtra("jsonObject"));
            opTeam = setup.getString("team2");
            ings = setup.getInt("innings");
            isBatting = setup.getBoolean("isBatting");
            totalOver = setup.getInt("tOv");
            targetRun = setup.getInt("target");
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    private void setupViews() {
        scoreMain = findViewById(R.id.scoreMain);
        target = findViewById(R.id.target);
        runReq = findViewById(R.id.runReq);
        extraRun = findViewById(R.id.extraRun);
        totalOv = findViewById(R.id.totalOv);
        ovRem = findViewById(R.id.ovRem);
        overDone = findViewById(R.id.overDone);
        crr = findViewById(R.id.crr);
        rrr = findViewById(R.id.rrr);

        batManMenu = findViewById(R.id.batManMenu);
        ballManMenu = findViewById(R.id.ballManMenu);

        r0 = findViewById(R.id.r0);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
        r7 = findViewById(R.id.r7);
        wd = findViewById(R.id.wd);
        nb = findViewById(R.id.nb);
        bye = findViewById(R.id.bye);
        lbye = findViewById(R.id.lbye);
        wicket = findViewById(R.id.wicket);
        undo = findViewById(R.id.undo);
        redo = findViewById(R.id.redo);
        copyToCb = findViewById(R.id.copyToCb);

        batman1 = findViewById(R.id.batman1);
        batman1_run = findViewById(R.id.batman1_run);
        batman1_ball = findViewById(R.id.batman1_ball);
        batman1_4s = findViewById(R.id.batman1_4s);
        batman1_6s = findViewById(R.id.batman1_6s);
        batman1_sr = findViewById(R.id.batman1_sr);
        batman2 = findViewById(R.id.batman2);
        batman2_run = findViewById(R.id.batman2_run);
        batman2_ball = findViewById(R.id.batman2_ball);
        batman2_4s = findViewById(R.id.batman2_4s);
        batman2_6s = findViewById(R.id.batman2_6s);
        batman2_sr = findViewById(R.id.batman2_sr);
        ballman = findViewById(R.id.ballman);
        ballman_over = findViewById(R.id.ballman_over);
        ballman_run = findViewById(R.id.ballman_run);
        ballman_wicket = findViewById(R.id.ballman_wicket);
        ballman_maiden = findViewById(R.id.ballman_maiden);
        ballman_eco = findViewById(R.id.ballman_eco);

        if(ings==1){
            target.setVisibility(View.INVISIBLE);
            runReq.setVisibility(View.INVISIBLE);
            rrr.setVisibility(View.INVISIBLE);
        }

        if(isBatting) ballManMenu.setVisibility(View.GONE);
        else batManMenu.setVisibility(View.GONE);


    }

    private void setupBtnOnClick() {
        r0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sh.handleButtonClick(R.id.r0);
            }
        });
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r1);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r2);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r3);
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r4);
            }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r5);
            }
        });
        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r6);
            }
        });
        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.r7);
            }
        });
        wd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnButton=-1;
                new AlertDialog.Builder(ScoringActivity.this).setTitle(R.string.cooseBowler).setItems(new String[]{"0wd","1wd","2wd","3wd","4wd","5wd","6wd","7wd","Wd+Wkt"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        runOnButton = i;
                    }
                }).show();
                if(runOnButton == -1) return;
                sh.handleButtonClick(R.id.wd,runOnButton+"");
            }
        });
        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnButton=-1;
                new AlertDialog.Builder(ScoringActivity.this).setTitle(R.string.cooseBowler).setItems(new String[]{"0nb","1nb","2nb","3nb","4nb","5nb","6nb","7nb","Nb+Wkt"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        runOnButton = i;
                    }
                }).show();
                if(runOnButton == -1) return;
                sh.handleButtonClick(R.id.wd,runOnButton+"");
            }
        });
        bye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.bye);
            }
        });
        lbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh.handleButtonClick(R.id.lbye);
            }
        });
        wicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnButton=-1;
                int runCompl =0;
                String[] outTypes = new String[]{"Bowled","Caught","LBW","Stumped","Hit Wicket","Caught & Bowled","Run Out"};
                new AlertDialog.Builder(ScoringActivity.this).setTitle(R.string.chooseOuyType).setItems(outTypes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        runOnButton = i;
                    }
                }).show();
                if(runOnButton == -1) return;
                switch (runOnButton){
                    case 0:
                        sh.handleButtonClick(R.id.wicket,"Bowled");
                        break;
                    case 1:
                        sh.handleButtonClick(R.id.wicket,"Caught");
                        new AlertDialog.Builder(ScoringActivity.this).setMessage("Did the batsman cross?").setNegativeButton("No", null).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //radio change here
                            }
                        }).show();
                        break;
                    case 2:
                        sh.handleButtonClick(R.id.wicket,"LBW");
                        break;
                    case 3:
                        new AlertDialog.Builder(ScoringActivity.this).setTitle("Choose Extra").setSingleChoiceItems(new String[]{"None", "Wide", "No-ball"}, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i){
                                    case 1:
                                        sh.handleButtonClick(R.id.wicket,"Stumped","Wd");
                                    case 2:
                                        sh.handleButtonClick(R.id.wicket,"Stamped","Nb");
                                }
                            }
                        }).setPositiveButton("Okay",null).show();
                        break;
                    case 4:
                        new AlertDialog.Builder(ScoringActivity.this).setTitle("Choose Extra").setSingleChoiceItems(new String[]{"None", "Wide", "No-ball"}, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i){
                                    case 1:
                                        sh.handleButtonClick(R.id.wicket,"Hit Wicket","Wd");
                                    case 2:
                                        sh.handleButtonClick(R.id.wicket,"Hit Wicket","Nb");
                                }
                            }
                        }).setPositiveButton("Okay",null).show();
                        break;
                    case 5:
                        sh.handleButtonClick(R.id.wicket,"Caught & Bowled");
                        break;
                    case 6:
                        View view1 = LayoutInflater.from(ScoringActivity.this).inflate(R.layout.run_out_layout,null);
                        new AlertDialog.Builder(ScoringActivity.this).setTitle("Run Out").setView(view1).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //add
                            }
                        }).show();
                        break;
                }
            }
        });
    }

    private void setBowlerStatus(){
        ballman.setText(sh.getBallmanName());
        ballman_over.setText(sh.getBallmanOver());
        ballman_run.setText(sh.getBallmanRun());
        ballman_wicket.setText(sh.getBallmanWicket());
        ballman_maiden.setText(sh.getBallmanMaiden());
        ballman_eco.setText(sh.getBallmanEco());
    }
    private void setBatman1Status(){
        batman1.setText(sh.getBatman1Name());
        batman1_run.setText(sh.getBatman1Run());
        batman1_ball.setText(sh.getBatman1Ball());
        batman1_4s.setText(sh.getBatman14s());
        batman1_6s.setText(sh.getBatman16s());
        batman1_sr.setText(sh.getBatman1SR());
    }
    private void setBatman2Status(){
        batman2.setText(sh.getBatman2Name());
        batman2_run.setText(sh.getBatman2Run());
        batman2_ball.setText(sh.getBatman2Ball());
        batman2_4s.setText(sh.getBatman24s());
        batman2_6s.setText(sh.getBatman26s());
        batman2_sr.setText(sh.getBatman2SR());
    }

    private void setScore(){
        scoreMain.setText(isBatting?"ECE":opTeam+":"+sh.getScoreMain());
    }

    private void setTarget(){
        target.setText("Target:"+targetRun);
    }

    private void setExtra(){
        extraRun.setText("Extra:"+sh.getExtraRun());
    }

    private void setRunReq(){
        runReq.setText("Run Req:"+sh.getRunReq());
    }

    private void setOv(){
        overDone.setText("Ov:"+sh.getOverDone());
    }

    private void setTotalOv(){
        totalOv.setText("TotalOv:"+sh.getTotalOver());
    }

    private void setOvRem(){
        ovRem.setText("OvRem:"+sh.getOverRem());
    }

    private void setRRR(){
        rrr.setText("RRR:"+sh.getRRR());
    }

    private void setCRR(){
        crr.setText("CRR:"+sh.getCRR());
    }
}