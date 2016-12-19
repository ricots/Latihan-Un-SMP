/*
****  Copyright © 2016 Engkungs™ ****
****  Special Thanks For:        ****
**** - Aide App Development      ****
**** - Aide Group Facebook       ****
**** - StackOverlow Forum        ****
**** - Github                    ****
**** - El-Mahmub                 ****
**** - Nur Romadhoni             ****
**** - Google                    ****

*/


package com.engkungs.unsmp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.view.*;
import android.support.v4.view.*;
import android.support.v4.app.*;
import com.engkungs.unsmp.material.*;
import android.content.res.*;
import android.view.animation.*;
import android.support.v7.app.*;
import android.content.*;
import android.widget.*;
import android.text.*;
import android.webkit.*;
import com.google.android.gms.ads.*;
import org.xml.sax.*;
import java.net.*;
import android.net.*;



public class MainActivity extends AppCompatActivity 
{
  private Animation am1,am2,am3,am4,am5,am6;
  private Toolbar engkungsToolBar;
  private ActionBar ab;
  private DrawerLayout engkungsDrawerLayout;
  private NavigationView engkungsNavigationView;
  private FragmentManager engkungsFragmentManager=getSupportFragmentManager();
  private ActionBarDrawerToggle engkungsActionBarDrawerToggle;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.engkungs_main);
	//set Default Fragment
	/* Animtion Sett*/
	
//find id
	engkungsToolBar = (Toolbar)
	  findViewById(R.id.engkungs_toolbar);
	engkungsDrawerLayout = (DrawerLayout)
	  findViewById(R.id.engkungs_main_drawerLayout);
	engkungsNavigationView = (NavigationView)
	  findViewById(R.id.engkungs_main_navigationView);
	  
	  /*
	 engkungs exxx
	 */
	MobileAds.initialize(getApplicationContext(), 
	"ca-app-pub-3339667180563364/2854941137");
	AdView pb=(AdView)findViewById(R.id.adView);
	AdRequest pbReq=new
	  AdRequest.Builder().build();
	pb.loadAd(pbReq);
	
	////////////////
	setSupportActionBar(engkungsToolBar);
	EngkungsContentDrawer(engkungsNavigationView);
	engkungsDrawerLayout.addDrawerListener(engkungsActionBarDrawerToggle);
	engkungsActionBarDrawerToggle = EngkungssetupDrawerToggle();


	if (savedInstanceState == null)
	{
	  engkungsFragmentManager.beginTransaction().
		replace(R.id.engkungs_main_kontent,
				new EngkungsBahasaIndonesia()).
		commit();
	}
  }

  	

  private ActionBarDrawerToggle EngkungssetupDrawerToggle()
  {
	// TODO: Implement this method
	return new ActionBarDrawerToggle(
	  this, engkungsDrawerLayout,
	  engkungsToolBar,
	  R.string.open_drawer,
	  R.string.close_drawer);
  }

  private void EngkungsContentDrawer(NavigationView engkungsNavigationViewView)
  {
	// TODO: Implement this method
	engkungsNavigationViewView.setNavigationItemSelectedListener(
	  new NavigationView.OnNavigationItemSelectedListener(){

		@Override
		public boolean onNavigationItemSelected(MenuItem p1)
		{
		  // TODO: Implement this method
		  EngkungsSelectedDrawer(p1);

		  return true;
		}
	  });

  }
  public void EngkungsSelectedDrawer(MenuItem item)
  {
	// TODO: Implement this method
	Fragment engkungsFragment=null;
	Class engkungsClass;
	switch (item.getItemId())
	{
	  case R.id.engkungs_menu_bahasa_indonesia:
		engkungsClass = EngkungsBahasaIndonesia.class;
		break;
	  case R.id.engkungs_menu_bahasa_inggris:
		engkungsClass = EngkungsBahasaInggris.class;
		break;
	  case R.id.engkungs_menu_matematika:
		engkungsClass = EngkungsMatematika.class;
		break;
	  case R.id.engkungs_menu_ipa:
		engkungsClass = EngkungsIpa.class;
		break;
	  case R.id.engkungs_menu_about:
		engkungsClass = EngkungsAboutActivity.class;
		break;
	  default:
		engkungsClass = EngkungsBahasaIndonesia.class;
	}
	try
	{
	  engkungsFragment = (Fragment)engkungsClass.newInstance();
	}
	catch (Exception e)
	{
	  e.printStackTrace();
	}
	engkungsFragmentManager.beginTransaction().
	  replace(R.id.engkungs_main_kontent, engkungsFragment).
	  commit();
	item.setChecked(true);
	setTitle(item.getTitle());
	engkungsDrawerLayout.closeDrawers();
  }


  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
	if (engkungsActionBarDrawerToggle.onOptionsItemSelected(item))
	{
	  return true;
	}
	// TODO: Implement this method
	switch (item.getItemId())
	{
	  case R.id.engkungs_menu_donasi:

		AlertDialog.Builder dn=new
		  AlertDialog.Builder(this);
		dn.setTitle("Open Donasi");
		dn.setMessage("jika anda ingin donasi kepada pengembang, silahkan kontak email/facebook pengembang");
		dn.setNegativeButton("email", null);
		dn.setPositiveButton("facebook", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface p1, int p2)

			{

			   String fb= "http://www.facebook.com/engkungs";
			   Intent fbi=new
			   Intent (Intent.ACTION_VIEW);
			   fbi.setData(Uri.parse(fb));
			   startActivity(fbi);
			}


		  });
		dn.setNeutralButton("batal", null);
		dn.show();
		break;
	  case R.id.engkungs_menu_exit:
		AlertDialog.Builder kl=new
		  AlertDialog.Builder(this);
		kl.setTitle("Konfirmasi keluar");
		kl.setMessage("Apakah anda yakin mau keluar ?");
		kl.setIcon(R.drawable.ic_launcher);
		kl.setPositiveButton("ya", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface p1, int p2)
			{
			  // TODO: Implement this method
			  finish();
			}


		  });
		kl.setNegativeButton("tidak", null);
		kl.show();
		break;
	}
	return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState)
  {
	// TODO: Implement this method
	engkungsActionBarDrawerToggle.syncState();
	super.onPostCreate(savedInstanceState);

  }

  @Override
  public void onConfigurationChanged(Configuration newConfig)
  {
	// TODO: Implement this method
	engkungsActionBarDrawerToggle.onConfigurationChanged(newConfig);
	super.onConfigurationChanged(newConfig);

  }
  public void tes(View v)
  {
	finish();
  }

  @Override
  public void onBackPressed()
  {
	// TODO: Implement this method
	if (engkungsDrawerLayout.isDrawerOpen(GravityCompat.START))
	{
	  engkungsDrawerLayout.closeDrawer(GravityCompat.START);
	}
	else
	{
	  int fragments=getFragmentManager().getBackStackEntryCount();

	  if (fragments > 0)
	  {
		super.onBackPressed();
	  }
	  else
	  {
		AlertDialog.Builder kl=new
		  AlertDialog.Builder(this);
		kl.setTitle("Konfirmasi keluar");
		kl.setMessage("Apakah anda yakin mau keluar ?");
		kl.setIcon(R.drawable.ic_launcher);
		kl.setPositiveButton("ya", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface p1, int p2)
			{
			  // TODO: Implement this method
			  finish();
			}


		  });
		kl.setNegativeButton("tidak", null);
		kl.show();
	  }
	}

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
	MenuInflater engkungsMenuOptions=getMenuInflater();
	engkungsMenuOptions.inflate(R.menu.engkungs_menu_options, menu);
	// TODO: Implement this method
	return super.onCreateOptionsMenu(menu);
  }

}
