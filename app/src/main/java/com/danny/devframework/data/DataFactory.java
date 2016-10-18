package com.danny.devframework.data;

/**
 * Created by apple on 16/10/18.
 */

public class DataFactory
{
    public static DataObject createData(DataType aType)
    {
        DataObject object = null;
        switch (aType)
        {
            case EAccount:
                object = new Account();
                break;
        }

        return object;
    }
}
