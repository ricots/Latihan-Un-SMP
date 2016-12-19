package com.engkungs.unsmp.material;
import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.JsResult;
import android.support.v7.app.AlertDialog;
import com.engkungs.unsmp.R;
import com.google.android.gms.ads.AdView;
import android.content.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;

public class EngkungsBahasaInggris extends Fragment
{
private Context ly;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		View engkungs=inflater.
		inflate(R.layout.engkungs_bahasa_inggris,
		container,
		false);
		
		
		WebView bi=(WebView)engkungs.findViewById(R.id.engkungs_material_bin);
		WebSettings st=bi.getSettings();
		st.setJavaScriptEnabled(true);
		st.setSupportZoom(true);
		bi.requestFocusFromTouch();
	    bi.loadUrl ("file:///android_asset/engkungs_material_bahasa_inggris.html");
		bi.setWebChromeClient(new WebChromeClient(){
				public boolean onJsAlert(WebView wb,String url,String msg,JsResult result){
					final JsResult rslt=result;
					new AlertDialog.Builder(wb.getContext()).setMessage(msg).setNeutralButton("Iya Saya tahu", new AlertDialog.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								rslt.confirm();

							}


						})
						.setCancelable(false).create().show();
					return true;
				}
			});
	  
		return engkungs;
	}

	}
	
		
