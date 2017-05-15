package com.bihe0832.readhub.framework;import android.content.Context;import android.content.pm.PackageInfo;import android.content.pm.PackageManager;import android.os.Looper;import com.bihe0832.readhub.R;import com.bihe0832.readhub.framework.request.RequestServer;import com.bihe0832.readhub.libware.file.Logger;import com.bihe0832.readhub.libware.thread.ShakebaThreadManager;public class Shakeba {	private Context mApplicationContext = null;    private String mVersionName = "1.0.0";    private int mVersionCode = 1;    private boolean mIsGameStarting = false;    //是否为调试版本，主要用于开发中打一些提供给游戏定位问题    private static final boolean IS_TEST_VERSION = true;	private static volatile Shakeba instance = null;    // 全局变量的初始化	public void init(Context context) {        mApplicationContext = context;        try {            PackageInfo pi = mApplicationContext.getPackageManager().getPackageInfo(mApplicationContext.getPackageName(),0);            mVersionName = pi.versionName;            mVersionCode = pi.versionCode;        } catch (PackageManager.NameNotFoundException e) {            e.printStackTrace();            mVersionName = getStringById(R.string.app_version_name);            mVersionCode = getIntegerById(R.integer.app_version_code);        }        Logger.init(mApplicationContext, null);	}	public static Shakeba getInstance() {		if (instance == null) {			synchronized (Shakeba.class) {				if (instance == null) {					instance = new Shakeba();				}			}		}		return instance;	}    public Looper getLooper(int type) {        return ShakebaThreadManager.getInstance().getLooper(type);    }    public Context getApplicationContext() {        return mApplicationContext;    }    public boolean isGameStarting(){        return mIsGameStarting;    }    public void startGame(){        mIsGameStarting = true;    }    public void pauseGame(){        mIsGameStarting = false;    }    public String getStringById(int id) {        if(null != mApplicationContext){            try {                return mApplicationContext.getResources().getString(id);            }catch (Exception e){                e.printStackTrace();                return "";            }        }else{            return "";        }    }    public float getDimenById(int id) {        if(null != mApplicationContext){            try {                return mApplicationContext.getResources().getDimension(id);            }catch (Exception e){                e.printStackTrace();                return 0;            }        }else{            return 0;        }    }    public int getIntegerById(int id) {        if(null != mApplicationContext){            try {                return mApplicationContext.getResources().getInteger(id);            }catch (Exception e){                e.printStackTrace();                return 0;            }        }else{            return 0;        }    }    public boolean isDebug() {        return IS_TEST_VERSION;    }    public String getVersionName(){        return mVersionName;    }    public int getVersionCode(){        return mVersionCode;    }}