package com.engkungs.unsmp.material;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.engkungs.unsmp.*;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import java.util.*;
import android.support.v4.view.*;

public class EngkungsMatematika extends Fragment
{
	ViewPager vp;
	TabLayout tl;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		View engkungs=inflater.
			inflate(R.layout.engkungs_matematika,
					container,
					false);
		vp = (ViewPager)engkungs.findViewById(
			R.id.engkungs_vp_matemtik);
		tl = (TabLayout)engkungs.findViewById(
			R.id.engkungs_tablayout);


		return engkungs;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onActivityCreated(savedInstanceState);
		if (ViewCompat.isLaidOut(tl))
		{
			AturVpListener();
		}
		else
		{
			tl.addOnLayoutChangeListener(new View.OnLayoutChangeListener(){

					@Override
					public void onLayoutChange(
						View v,
						int left, 
						int top, 
						int right, 
						int bottom, 
						int oldLeft, 
						int oldTop, 
						int oldRight, 
						int oldBottom)
					{
						AturVpListener();
						tl.removeOnLayoutChangeListener(this);
						tl.setupWithViewPager(vp);
						tl.setOnTabSelectedListener(new 
							TabLayout.ViewPagerOnTabSelectedListener(vp){
								@Override
								public void onTabReselected
								(TabLayout. Tab tab)
								{
									super .onTabReselected(tab);
								}
								@Override
								public void onTabSelected
								(TabLayout. Tab tab)
								{
									super .onTabSelected(tab);
								}
							});
					}


				});
		}
		setupViewPager(vp);
		tl.setupWithViewPager(vp);
		tl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

				@Override
				public void onTabSelected(TabLayout.Tab p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTabUnselected(TabLayout.Tab p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTabReselected(TabLayout.Tab p1)
				{
					// TODO: Implement this method
				}


			});
	}

	private void AturVpListener()
	{
		// TODO: Implement this method
	}

	private void setupViewPager(ViewPager vp)
	{
		// TODO: Implement this method
		VpAdapter vpa=new VpAdapter(getChildFragmentManager());
		vpa.tambahFragment(new EngkungsMatematikaSatu(), "Soal");
		vpa.tambahFragment(new EngkungsMatematikaDua(), "jawab");
		vp.setAdapter(vpa);
	}
	private class VpAdapter extends FragmentPagerAdapter
	{
		List<Fragment>fragmenList=new
		ArrayList<>();
		List<String>fragmentJudul=new
		ArrayList<>();
		public VpAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int posisi)
		{
			// TODO: Implement this method
			return fragmenList.get(posisi);
		}
		@Override
		public int getCount()
		{
			// TODO: Implement this method
			return fragmenList.size();
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			// TODO: Implement this method
			return fragmentJudul.get(position);
		}



		public void tambahFragment(Fragment fr , String nama)
		{
			// TODO: Implement this method
			fragmenList.add(fr);
			fragmentJudul.add(nama);
		}
	}
}
