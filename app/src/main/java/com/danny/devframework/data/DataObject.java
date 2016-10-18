package com.danny.devframework.data;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by danny on 10/17/16.
 */

abstract class DataObject {
    private static final String TAG = "BaseData";

    protected static final String   JSON_ID = "id";
    protected static final String   JSON_ITEM_ID = "itemId";
    protected static final String   JSON_DATE = "date";

    private static final String     JSON_EXPAND_DATA = "expData";

    private DataType mType = DataType.ENone;

    private ArrayList<WeakReference<DataCallbacks>> mCallbackList = null;

    protected DataObject(DataType aType)
    {
        mType = aType;
    }

    public DataObject()
    {
        this(DataType.ENone);
    }

    public DataType getType()
    {
        return mType;
    }

    public void registerCallbacks(DataCallbacks aCallbacks)
    {
        Log.d(TAG, "registerCallbacks");
        if (aCallbacks != null)
        {
            if (mCallbackList == null)
            {
                mCallbackList = new ArrayList<>();
            }

            if (!mCallbackList.isEmpty())
            {
                for (WeakReference<DataCallbacks> callbacks : mCallbackList)
                {
                    DataCallbacks cb = callbacks.get();
                    if (cb == aCallbacks)
                    {
                        return;
                    }
                }
            }

            WeakReference<DataCallbacks> callbacks = new WeakReference<>(aCallbacks);

            if (!mCallbackList.contains(callbacks))
            {
                Log.d(TAG, "registerCallbacks");
                mCallbackList.add(callbacks);
            }
        }
    }

    public void unregisterCallbacks(DataCallbacks aCallbacks)
    {
        Log.d(TAG, "unregisterCallbacks");
        if (aCallbacks != null && mCallbackList != null)
        {
            WeakReference<DataCallbacks> rm = null;
            if (!mCallbackList.isEmpty())
            {
                for (WeakReference<DataCallbacks> callbacks : mCallbackList)
                {
                    DataCallbacks cb = callbacks.get();
                    if (cb == aCallbacks)
                    {
                        rm = callbacks;
                        break;
                    }
                }
            }

            if (rm != null)
            {
                mCallbackList.remove(rm);
            }
        }
    }

    protected void notifyALL()
    {
        if (mCallbackList != null && !mCallbackList.isEmpty())
        {
            for (WeakReference<DataCallbacks> callbacks : mCallbackList)
            {
                DataCallbacks cb = callbacks.get();
                if (cb != null)
                {
                    cb.update();
                }
            }
        }
    }

    protected void init(String aContent)
    {
        if (!TextUtils.isEmpty(aContent))
        {
            try {
                JSONObject jsonObject = new JSONObject(aContent);
                init(jsonObject);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    protected abstract void init(JSONObject aObject) throws JSONException;

    protected JSONObject toJson()
    {
        JSONObject jsonObject = new JSONObject();

        try
        {
            initObject(jsonObject);

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return jsonObject;
    }

    protected abstract void initObject(JSONObject aObject) throws JSONException;

    protected String jsonContent()
    {
        JSONObject jsonObject = toJson();
        return jsonObject.toString();
    }

    protected void putJSONObject(JSONObject aObject, String aKey, boolean aValue, boolean aDefault) throws JSONException
    {
        if (aValue != aDefault)
        {
            aObject.put(aKey, aValue);
        }
    }

    protected void putJSONObject(JSONObject aObject, String aKey, int aValue, int aDefault) throws JSONException
    {
        if (aValue != aDefault)
        {
            aObject.put(aKey, aValue);
        }
    }

    protected void putJSONObject(JSONObject aObject, String aKey, double aValue, double aDefault) throws JSONException
    {
        if (aValue != aDefault)
        {
            aObject.put(aKey, aValue);
        }
    }

    protected void putJSONObject(JSONObject aObject, String aKey, long aValue, long aDefault) throws JSONException
    {
        if (aValue != aDefault)
        {
            aObject.put(aKey, aValue);
        }
    }

    protected void putJSONObject(JSONObject aObject, String aKey, String aValue, String aDefault) throws JSONException
    {
        if (!aValue.equals(aDefault))
        {
            aObject.put(aKey, aValue);
        }
    }

    @Override
    public String toString() {
        return "DataType: " + mType;
    }
}
