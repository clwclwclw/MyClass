package cn.edu.sdwu.android.classroom.sn170507180230;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CH5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch5_1);

    }
    public void startMain(View view){
        Toast.makeText(this,"成功",Toast.LENGTH_LONG).show();
    }
    public void startMain1(View view){
        Toast toast=Toast.makeText(this,"成功",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);//0,0就是在中间不偏移
        toast.show();
    }
    public void toast(View view){
        //加载自定义的布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater=getLayoutInflater();
        View view1=layoutInflater.inflate(R.layout.layout_toast,null);

        //设置显示文本
        TextView textView=(TextView) view1.findViewById(R.id.toast_tv);
        textView.setText("toast3");

        Toast toast=new Toast(this);
        toast.setView(view1);//设置界面样式
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    //2.notification 提示
    public void notification(View view){
        Notification.Builder builder=new Notification.Builder(this);//内部类
        //在构造器中，完成通知各种属性的设置
        builder.setContentTitle("title");
        builder.setContentText("message");
        builder.setWhen(System.currentTimeMillis());//时间戳
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统的资源,这里图标一般是ic开头，设置图标
        //调用build方法完成构造
        Notification notification=builder.build();
        //使用NotificationManager,发送通知
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);//发送编号，
    }
    public void cancel_notification(View view){
        //使用Notification取消通知
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }
    //d
    public void alert_dialog(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(CH5Activity1.this,"confirm",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("exit",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(CH5Activity1.this,"exit",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(CH5Activity1.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }

}


