package com.engkungs.unsmp;
import android.support.v4.app.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.content.*;
import android.widget.*;



public class EngkungsAboutActivity extends Fragment
{
private Animation m1,m2,m3,m4,m5;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		View engkungsView=inflater.inflate(
		R.layout.engkungs_about,container,false);
		Context vv=engkungsView.getContext();
		
		
	m1=AnimationUtils.loadAnimation(vv,R.anim.design_fab_out);
	m1.setDuration(4000);
		ImageView img=(ImageView)engkungsView.findViewById(R.id.engkungsaboutImageView1);
		img.setAnimation(m1);
		return engkungsView;
	}
	
}
