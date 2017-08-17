package zhou.anew.com.newapp.mvp.view.keyboardNumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import zhou.anew.com.newapp.R;
import zhou.anew.com.newapp.mvp.view.textView.Main8Activity;

public class Main7Activity extends AppCompatActivity{

    private EditText et_input,et_input2;
    private LinearLayout ll_keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        initId();
        et_input = (EditText) findViewById(R.id.et_input);
        et_input2 = (EditText) findViewById(R.id.et_input2);
        ll_keyboard = (LinearLayout) findViewById(R.id.ll_keyboard);
        et_input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    ll_keyboard.setVisibility(View.GONE);
                }
            }
        });
        et_input.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int intputType = et_input.getInputType();
                et_input.setInputType(InputType.TYPE_NULL);
                ll_keyboard.setVisibility(View.VISIBLE);
                et_input.setInputType(intputType);
                et_input.setSelection(et_input.getText().toString().length());
                return false;
            }
        });
        et_input2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int intputType = et_input2.getInputType();
                et_input2.setInputType(InputType.TYPE_NULL);
                et_input2.setInputType(intputType);
                return false;
            }
        });
    }

    private void initId() {
        TextView tv_number_0 = (TextView) findViewById(R.id.tv_number_0);
        TextView tv_number_1 = (TextView) findViewById(R.id.tv_number_1);
        TextView tv_number_2 = (TextView) findViewById(R.id.tv_number_2);
        TextView tv_number_3 = (TextView) findViewById(R.id.tv_number_3);
        TextView tv_number_4 = (TextView) findViewById(R.id.tv_number_4);
        TextView tv_number_5 = (TextView) findViewById(R.id.tv_number_5);
        TextView tv_number_6 = (TextView) findViewById(R.id.tv_number_6);
        TextView tv_number_7 = (TextView) findViewById(R.id.tv_number_7);
        TextView tv_number_8 = (TextView) findViewById(R.id.tv_number_8);
        TextView tv_number_9 = (TextView) findViewById(R.id.tv_number_9);
        TextView tv_number_ok = (TextView) findViewById(R.id.tv_number_ok);
        ImageView iv_delect = (ImageView) findViewById(R.id.iv_delect);
        tv_number_0.setOnClickListener(onClickListener);
        tv_number_1.setOnClickListener(onClickListener);
        tv_number_2.setOnClickListener(onClickListener);
        tv_number_3.setOnClickListener(onClickListener);
        tv_number_4.setOnClickListener(onClickListener);
        tv_number_5.setOnClickListener(onClickListener);
        tv_number_6.setOnClickListener(onClickListener);
        tv_number_7.setOnClickListener(onClickListener);
        tv_number_8.setOnClickListener(onClickListener);
        tv_number_9.setOnClickListener(onClickListener);
        iv_delect.setOnClickListener(onClickListener);
        tv_number_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("input_text",":" + et_input.getText().toString());
                startActivity(new Intent(Main7Activity.this,Main8Activity.class));
//                overridePendingTransition(R.anim.enter,R.anim.exit);

            }
        });
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Editable editable = et_input.getText();
            switch (view.getId()){
                case R.id.tv_number_0:
                    editable.append("0");
                    break;
                case R.id.tv_number_1:
                    editable.append("1");
                    break;
                case R.id.tv_number_2:
                    editable.append("2");
                    break;
                case R.id.tv_number_3:
                    editable.append("3");
                    break;
                case R.id.tv_number_4:
                    editable.append("4");
                    break;
                case R.id.tv_number_5:
                    editable.append("5");
                    break;
                case R.id.tv_number_6:
                    editable.append("6");
                    break;
                case R.id.tv_number_7:
                    editable.append("7");
                    break;
                case R.id.tv_number_8:
                    editable.append("8");
                    break;
                case R.id.tv_number_9:
                    editable.append("9");
                    break;
                case R.id.iv_delect:
                    int index = et_input.getSelectionStart();
                    if(editable.length() > 0 && index > 0){
                        editable.delete(index - 1 , index);
                    }
                    break;
            }
            et_input.setText(editable);
            et_input.setSelection(editable.length());
        }
    };


}
