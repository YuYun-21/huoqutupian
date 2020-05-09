package com.example.huoqutouxiang;

import android.app.Activity;
import android.os.Bundle;
import com.example.huoqutouxiang.R;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button button;//获取图片资源btn
	private ImageView imageview;
	private String psw;
    private EditText et_psw;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imageview = (ImageView) findViewById(R.id.imageview);
        et_psw=(EditText) findViewById(R.id.et_psw);
        
        
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
            	psw=et_psw.getText().toString().trim();
                imageview.setImageBitmap(getRes(psw));
                if (TextUtils.isEmpty(psw)){
                	Toast.makeText(MainActivity.this, "请输入图片名称", Toast.LENGTH_SHORT).show();
                	return;
                }
                else if(getRes(psw)==null){
                		Toast.makeText(MainActivity.this, "没有此图", Toast.LENGTH_SHORT).show();
                		return;
                }
           }
       });
    }
    
    //获取Res下的drawable文件夹下图片资源
    private Bitmap getRes(String imageName) {
        ApplicationInfo  appInfo = this.getApplicationInfo();
        int resID = getResources().getIdentifier(imageName, "drawable", appInfo.packageName);
        return BitmapFactory.decodeResource(getResources(), resID);
    }
}
