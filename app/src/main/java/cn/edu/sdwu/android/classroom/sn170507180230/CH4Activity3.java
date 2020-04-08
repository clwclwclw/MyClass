package cn.edu.sdwu.android.classroom.sn170507180230;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CH4Activity3 extends AppCompatActivity {
    private ArrayList list;//定义
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch4_3);

        list=new ArrayList();
        textView=(TextView) findViewById(R.id.ch4_3_tv);
        //通过界面的容器，找到它所包含的所有子元素，再来注册监听器
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch4_3_11);
        int count=linearLayout.getChildCount();//定义linearLayout里复选框的个数
        for(int i=0;i<count;i++){
            View view=linearLayout.getChildAt(i);//View的getChildAt(i)方法只能获取显示在屏幕上的内容，其中i参数为列表子项在可视范围内的第几项。
            if(view instanceof CheckBox){//instanceof的作用是判断其左边对象是否为其右边类的实例，返回boolean类型的数据。
                final CheckBox checkBox=(CheckBox)view;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        //参数b代表是否选中,第一个参数代表事件源
                        if(b){
                            list.add(compoundButton);//如果b表示当前的checkbox被选中，添加到list里,这个compoundButton是获取当前对象                        }else{
                            list.remove(compoundButton);//否则从list里移出
                        }
                        String content="you select";
                        //循环输出选择的东西
                        for(int t=0;t<list.size();t++){
                            CheckBox checkBox1=(CheckBox) list.get(t);//在这里list里的是对象，所以要取出来
                            String sel=checkBox1.getText().toString();
                            content+=sel+",";
                        }
                        textView.setText(content);
                    }
                });
            }
        }
    }
}

