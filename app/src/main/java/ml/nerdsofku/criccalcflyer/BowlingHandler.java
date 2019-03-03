package ml.nerdsofku.criccalcflyer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;

public class BowlingHandler implements ScoringHandler {

    private Calculate c;
    private Bowler bowler;
    private int wicket,extraRun;
    private Context context;
    String[] players;
    private boolean doesHaveBowler;

    public BowlingHandler(int totalOver, int terget, Context context){
        c = new Calculate(totalOver, terget);
        bowler = new Bowler();
        wicket = extraRun = 0;
        doesHaveBowler = false;
        this.context = context;
        players = new String[11];
        try{
            JSONObject jsonObject = new JSONObject(new String(IOUtils.toByteArray(new FileInputStream(new File(context.getFilesDir()+"/playerNames.json"))),"UTF-8"));
            for(int i=0;i<11;i++){
                players[i] = jsonObject.getString("player"+i);
            }
        } catch (Exception ex){}

    }

    @Override
    public void popupforName() {
        new AlertDialog.Builder(context).setTitle(R.string.cooseBowler).setItems(players, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                bowler.setName(players[i]);
            }
        }).show();
    }

    @Override
    public String getScoreMain() {
        return " "+c.getRunDone()+"/"+wicket;
    }

    @Override
    public String getTarget() {
        return " "+c.getTarget();
    }

    @Override
    public String getRunReq() {
        return " "+c.getRunReq();
    }

    @Override
    public String getExtraRun() {
        return " "+extraRun;
    }

    @Override
    public String getTotalOver() {
        return " "+c.getTotalOver();
    }

    @Override
    public String getOverRem() {
        return " "+c.getOverRemain();
    }

    @Override
    public String getOverDone() {
        return " "+c.getOverDone();
    }

    @Override
    public String getCRR() {
        return " "+c.getCRR();
    }

    @Override
    public String getRRR() {
        return " "+c.getRRR();
    }

    @Override
    public String getBatman1Name() {
        return "";
    }

    @Override
    public String getBatman1Run() {
        return "";
    }

    @Override
    public String getBatman1Ball() {
        return "";
    }

    @Override
    public String getBatman14s() {
        return "";
    }

    @Override
    public String getBatman16s() {
        return "";
    }

    @Override
    public String getBatman1SR() {
        return "";
    }

    @Override
    public String getBatman2Name() {
        return "";
    }

    @Override
    public String getBatman2Run() {
        return "";
    }

    @Override
    public String getBatman2Ball() {
        return "";
    }

    @Override
    public String getBatman24s() {
        return "";
    }

    @Override
    public String getBatman26s() {
        return "";
    }

    @Override
    public String getBatman2SR() {
        return "";
    }

    @Override
    public String getBallmanRun() {
        return bowler.getRun();
    }

    @Override
    public String getBallmanWicket() {
        return bowler.getWicket();
    }

    @Override
    public String getBallmanMaiden() {
        return bowler.getMaiden();
    }

    @Override
    public String getBallmanEco() {
        return bowler.getEcon();
    }

    @Override
    public String getBallmanName() {
        return bowler.getName();
    }

    @Override
    public String getBallmanOver() {
        return bowler.getOverPlayed();
    }

    @Override
    public void handleButtonClick(int button, String... args) {
        if(!doesHaveBowler){
            popupforName();
            return;
        }
        int runOnButton;
        switch (button){
            case R.id.r0:
                bowler.doBall(0);
                c.calculate(0);
                break;
            case R.id.r1:
                bowler.doBall(1);
                c.calculate(1);
                break;
            case R.id.r2:
                bowler.doBall(2);
                c.calculate(2);
                break;
            case R.id.r3:
                bowler.doBall(3);
                c.calculate(3);
                break;
            case R.id.r4:
                bowler.doBall(4);
                c.calculate(4);
                break;
            case R.id.r6:
                bowler.doBall(6);
                c.calculate(6);
                break;
            case R.id.r7: //wd,nb,bye,lbye,wicket
                bowler.doBall(7);
                c.calculate(7);
                break;
            case R.id.wd:
                runOnButton = Integer.parseInt(args[0]);
                if(runOnButton==8){
                    new AlertDialog.Builder(context).setMessage(R.string.wdnbWktMsg).setNeutralButton(R.string.ok,null).show();
                    return;
                }
                bowler.doBall(false,1+runOnButton);
                c.calculate(false,1+runOnButton);
                break;
            case R.id.nb:
                runOnButton = Integer.parseInt(args[0]);
                if(runOnButton==8){
                    new AlertDialog.Builder(context).setMessage(R.string.wdnbWktMsg).setNeutralButton(R.string.ok,null).show();
                    return;
                }
                bowler.doBall(false,1+runOnButton);
                c.calculate(false,1+runOnButton);
                break;
            case R.id.lbye:
                bowler.doBall(true,0);
                c.calculate(true,0);
                break;
            case R.id.bye:
                bowler.doBall(true,0);
                c.calculate(true,0);
                break;
            case R.id.wicket:
                bowler.doBall(true,0,true);
                c.calculate(true,0);
                break;
        }
    }
}