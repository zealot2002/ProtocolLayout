import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

/**
 * zzy
 */
public class ProtocolLayout extends RelativeLayout {
    public interface OnProtocolClickListener{
        void onClicked(int position);
    }
    private List<String> dataList;
    private OnProtocolClickListener listener;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ProtocolLayout(@NonNull Context context) {
        super(context);
    }

    public ProtocolLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtocolLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProtocolLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(int textSize,int textColor,int protocolColor,float mult,List<String> list,OnProtocolClickListener listener) {
        this.dataList = list;
        this.listener = listener;

        TextView tv = new TextView(getContext());
        tv.setTextSize(textSize);
        final SpannableStringBuilder style = new SpannableStringBuilder();

        for(int i = 0;i<dataList.size();i++){
            int lastLen = style.length();
            //设置文字
            style.append(dataList.get(i));

            if(i!=0){
                final int index = i;
                //设置部分文字点击事件
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        ProtocolLayout.this.listener.onClicked(index);
                        avoidHintColor(widget);
                    }

                    //去除连接下划线
                    @Override
                    public void updateDrawState(TextPaint ds) {
                        ds.setUnderlineText(false);
                        ds.clearShadowLayer();
                    }
                };
                style.setSpan(clickableSpan, lastLen,style.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        ForegroundColorSpan color1 = new ForegroundColorSpan(getContext().getResources().getColor(textColor));
        style.setSpan(color1, 0,dataList.get(0).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(protocolColor));
        style.setSpan(foregroundColorSpan, dataList.get(0).length(), style.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(style);

        tv.setLineSpacing(0,mult);
        addView(tv);
    }

    private void avoidHintColor(View view){
        if(view instanceof TextView)
            ((TextView)view).setHighlightColor(getResources().getColor(android.R.color.transparent));
    }
}

