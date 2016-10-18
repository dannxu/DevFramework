package com.danny.devframework.data;

/**
 * Created by danny on 10/17/16.
 */

public enum DataType {
    EAccount("account"),
    ENone("none");

    private String mType;
    DataType(String aType)
    {
        mType = aType;
    }

    public String type()
    {
        return mType;
    }

    public static DataType getType(String aType)
    {
        for (DataType type : DataType.values())
        {
            if (type.type().equals(aType))
            {
                return type;
            }
        }

        return ENone;
    }
}
