package com.mukeshteckwani;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mukeshteckwani.models.Result;

/**
 * Created by mukeshteckwani on 15/08/16.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PharmEasy.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_MEDICINES_TABLE =
            "CREATE TABLE " + DBConstants.Medicines.TABLE_MEDICINES + " ("
                    + DBConstants.Medicines.COLUMN_AVAILABLE + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_DISC_PERC + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_DRUG_FORM + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_FORM + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_GENERICS + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_HKP_DRUG_CODE + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_ID + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_IMG_URL + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_LABEL + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_MANUFACTURER + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_MAPPED_P_FORM + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_META + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_MF_ID + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_MRP + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_NAME + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_OPRICE + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_P_FORM + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_PACK_FORM + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_PACK_SIZE + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_PACK_SIZE_LABEL + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_PRESCRIPTION_REQD + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_PRODUCTS_FOR_BRAND + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_SLUG + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_SU + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_THERAPUTIC_CLASS_NAME + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_TYPE + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_UIP + TEXT_TYPE + COMMA_SEP
                    + DBConstants.Medicines.COLUMN_UPRICE + TEXT_TYPE
                    + " )";
    private static DBHandler dbHandler;

    private DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DBHandler getInstance(Context context) {
        if (dbHandler == null) {
            dbHandler = new DBHandler(context);
        }
        return dbHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_MEDICINES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertToMedicinesTable(Result result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBConstants.Medicines.COLUMN_AVAILABLE,result.getAvailable());
        values.put(DBConstants.Medicines.COLUMN_DISC_PERC,result.getDiscountPerc());
        values.put(DBConstants.Medicines.COLUMN_DRUG_FORM,result.getDrug_form());
        values.put(DBConstants.Medicines.COLUMN_FORM,result.getForm());
        values.put(DBConstants.Medicines.COLUMN_GENERICS,result.getGenerics());
        values.put(DBConstants.Medicines.COLUMN_HKP_DRUG_CODE,result.getHkpDrugCode());
        values.put(DBConstants.Medicines.COLUMN_ID,result.getId());
        values.put(DBConstants.Medicines.COLUMN_IMG_URL,result.getImgUrl());
        values.put(DBConstants.Medicines.COLUMN_LABEL,result.getLabel());
        values.put(DBConstants.Medicines.COLUMN_MANUFACTURER,result.getManufacturer());
        values.put(DBConstants.Medicines.COLUMN_MAPPED_P_FORM,result.getMappedPForm());
        values.put(DBConstants.Medicines.COLUMN_META,result.getMeta());
        values.put(DBConstants.Medicines.COLUMN_MF_ID,result.getMfId());
        values.put(DBConstants.Medicines.COLUMN_MRP,result.getMrp());
        values.put(DBConstants.Medicines.COLUMN_NAME,result.getName());
        values.put(DBConstants.Medicines.COLUMN_OPRICE,result.getOPrice());
        values.put(DBConstants.Medicines.COLUMN_P_FORM,result.getPForm());
        values.put(DBConstants.Medicines.COLUMN_PACK_FORM,result.getPackForm());
        values.put(DBConstants.Medicines.COLUMN_PACK_SIZE,result.getPackSize());
        values.put(DBConstants.Medicines.COLUMN_PACK_SIZE_LABEL,result.getPackSizeLabel());
        values.put(DBConstants.Medicines.COLUMN_PRESCRIPTION_REQD,result.getPrescriptionRequired());
        values.put(DBConstants.Medicines.COLUMN_PRODUCTS_FOR_BRAND,result.getProductsForBrand());
        values.put(DBConstants.Medicines.COLUMN_SLUG,result.getSlug());
        values.put(DBConstants.Medicines.COLUMN_THERAPUTIC_CLASS_NAME,result.getTherapeuticClassName());
        values.put(DBConstants.Medicines.COLUMN_TYPE,result.getType());
        values.put(DBConstants.Medicines.COLUMN_UIP,result.getUip());
        values.put(DBConstants.Medicines.COLUMN_UPRICE,result.getUPrice());
        db.insert(DBConstants.Medicines.TABLE_MEDICINES,null,values);

    }

    public Result getMedicineName(int pos) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columName = new String[] {
                DBConstants.Medicines.COLUMN_NAME,
                DBConstants.Medicines.COLUMN_ID,
                DBConstants.Medicines.COLUMN_GENERICS,
                DBConstants.Medicines.COLUMN_AVAILABLE,
                DBConstants.Medicines.COLUMN_META
        };

        Cursor sessionCursor = db.query(DBConstants.Medicines.TABLE_MEDICINES,columName, "rowid=?", new String[] {""+(pos+1)}, null, null, null);
        if (sessionCursor!=null && sessionCursor.moveToFirst()) {
            Result medicine = new Result();
            medicine.setName(sessionCursor.getString(sessionCursor.getColumnIndex(DBConstants.Medicines.COLUMN_NAME)));
            medicine.setId(sessionCursor.getString(sessionCursor.getColumnIndex(DBConstants.Medicines.COLUMN_ID)));
            medicine.setGenerics(sessionCursor.getString(sessionCursor.getColumnIndex(DBConstants.Medicines.COLUMN_GENERICS)));
            medicine.setAvailable(sessionCursor.getString(sessionCursor.getColumnIndex(DBConstants.Medicines.COLUMN_AVAILABLE)));
            medicine.setMeta(sessionCursor.getString(sessionCursor.getColumnIndex(DBConstants.Medicines.COLUMN_META)));
            return medicine ;
        }

        return null;
    }

    public long getMedicineCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, DBConstants.Medicines.TABLE_MEDICINES);
    }
}
