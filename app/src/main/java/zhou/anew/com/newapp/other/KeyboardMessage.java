package zhou.anew.com.newapp.other;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import zhou.anew.com.newapp.R;

/**
 * Created by zhoukai on 2017/8/10.
 */
public class KeyboardMessage {

    private Context context;
    private EditText editText;
    private KeyBoardInterfer interfer;
    private AlertDialog alertDialog;
    private PopupWindow popupWindow;

    public KeyboardMessage(Context context, EditText editText, final KeyBoardInterfer interfer){
        this.context = context;
        this.editText = editText;
        this.interfer = interfer;
        initPopup();
    }

    private AlertDialog initDialog(){
        View view = View.inflate(context, R.layout.keyboard_layout,null);

        return new AlertDialog.Builder(context).setView(view).create();
    }

    private void initPopup(){
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.keyboard_layout, null, false);
        TextView tv_number_0 = (TextView) view.findViewById(R.id.tv_number_0);
        TextView tv_number_1 = (TextView) view.findViewById(R.id.tv_number_1);
        TextView tv_number_2 = (TextView) view.findViewById(R.id.tv_number_2);
        TextView tv_number_3 = (TextView) view.findViewById(R.id.tv_number_3);
        TextView tv_number_4 = (TextView) view.findViewById(R.id.tv_number_4);
        TextView tv_number_5 = (TextView) view.findViewById(R.id.tv_number_5);
        TextView tv_number_6 = (TextView) view.findViewById(R.id.tv_number_6);
        TextView tv_number_7 = (TextView) view.findViewById(R.id.tv_number_7);
        TextView tv_number_8 = (TextView) view.findViewById(R.id.tv_number_8);
        TextView tv_number_9 = (TextView) view.findViewById(R.id.tv_number_9);
        TextView tv_number_ok = (TextView) view.findViewById(R.id.tv_number_ok);
        ImageView iv_delect = (ImageView) view.findViewById(R.id.iv_delect);
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
        tv_number_ok.setOnClickListener(onClickListener);
        iv_delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interfer != null){
                    interfer.onEnter();
                }
            }
        });
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
    }

    public void openDialog(View view){
        if(popupWindow != null){
            popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,0);
        }
    }

    public void closeDialog(){
        if(popupWindow != null){
            popupWindow.dismiss();
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Editable editable = editText.getText();
            int index = editText.getSelectionStart();
            switch (view.getId()){
                case R.id.tv_number_0:
                    editable.append("0",index,index + 1);
                    break;
                case R.id.tv_number_1:
                    editable.append("1",index,index + 1);
                    break;
                case R.id.tv_number_2:
                    editable.append("2",index,index + 1);
                    break;
                case R.id.tv_number_3:
                    editable.append("3",index,index + 1);
                    break;
                case R.id.tv_number_4:
                    editable.append("4",index,index + 1);
                    break;
                case R.id.tv_number_5:
                    editable.append("5",index,index + 1);
                    break;
                case R.id.tv_number_6:
                    editable.append("6",index,index + 1);
                    break;
                case R.id.tv_number_7:
                    editable.append("7",index,index + 1);
                    break;
                case R.id.tv_number_8:
                    editable.append("8",index,index + 1);
                    break;
                case R.id.tv_number_9:
                    editable.append("9",index,index + 1);
                    break;
                case R.id.iv_delect:
                    if(editable.length() > 0 && index > 0){
                        editable.delete(index - 1 , index);
                    }
                    break;
            }
            editText.setText(editable);
        }
    };


    public interface KeyBoardInterfer{
        void onEnter();
    }

}
