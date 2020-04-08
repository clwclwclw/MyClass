package cn.edu.sdwu.android.classroom.sn17050718230;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CH4Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch4_2);

        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.ch4_1_rg);//找到事件源
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){//设置监听器

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                //第2个参数代表当前选中的radiobutton的ID
                RadioButton radioButton=(RadioButton) findViewById(i);
                Object object=radioButton.getTag();//获取tag
                TextView textView=(TextView) findViewById(R.id.ch4_1_tv);
                if(object!=null&&object.toString().equals("1")){
                    textView.setText("right");
                }else{
                    textView.setText("wrong");
                }
            }
        });
    }


}
