package joni.tattoo.studio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SUNAY on 11/30/13.
 */
public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="pwd.db";
    private static final int DATABASE_VERSION=1;

    //------TABLE Passwords -----------------------------------------------------------------------
    public static final String PWD="Passwords";
    public static final String ADMINNAME="_AdminName";
    public static final String ADMINPWD="_AdminPWD";

    private static final String DATABASE_CREATE_PWD = "create table " +PWD+
            "(" + ADMINNAME + " text primary key, " +
            ADMINPWD + " text);";
    //---------------------------------------------------------------------------------------------

    //------TABLE Tattoo---------------------------------------------------------------------------
    public static final String TATTOOS = "Tattoos";
    public static final String TATTOO_ID = "_ID";
    public static final String TATTOO_PHOTO = "_TPhoto";
    public static final String TATTOO_PRICE_S = "_TPriceS";
    public static final String TATTOO_PRICE_M = "_TPriceM";
    public static final String TATTOO_PRICE_L = "_TPriceL";
    public static final String TATTOO_COLOUR="_TColour";
    public static final String TATTOO_DIFFICULTY = "_TDifficulty";

    private static final String DATABASE_CREATE_TATTOOS = "create table " + TATTOOS +
            "(" + TATTOO_ID + " integer primary key autoincrement, " +
            TATTOO_PHOTO + " string  not null, " +
            TATTOO_PRICE_S + " real not null, " +
            TATTOO_PRICE_M + " real not null, " +
            TATTOO_PRICE_L + " real not null, " +
            TATTOO_COLOUR + " integer not null, " +
            TATTOO_DIFFICULTY + " integer  not null);";
    //---------------------------------------------------------------------------------------------

    //------TABLE Piercing-------------------------------------------------------------------------
    public static final String PIERCING = "Piercing";
    public static final String PIERCING_ID = "_ID";
    public static final String PIERCING_PHOTO = "_PPhoto";
    public static final String PIERCING_PRICE = "_PPrice";
    public static final String PIERCING_MATERIAL = "_PMaterial";
    public static final String PIERCING_AREA = "_PArea";

    private static final String DATABASE_CREATE_PIERCING = "create table " + PIERCING +
            "(" + PIERCING_ID + " integer primary key autoincrement, " +
            PIERCING_PHOTO + " string  not null, " +
            PIERCING_PRICE + " real not null, " +
            PIERCING_MATERIAL + " integer not null, " +
            PIERCING_AREA + " integer  not null);";
    //---------------------------------------------------------------------------------------------

    //------TABLE PiercingMaterial-----------------------------------------------------------------
    public static final String PIERCINGMAT = "PiercingMat";
    public static final String PIERCINGMAT_ID = "_ID";
    public static final String PIERCINGMAT_NAME = "_PMatName";

    private static final String DATABASE_CREATE_PIERCINGMAT = "create table " + PIERCINGMAT +
            "(" + PIERCINGMAT_ID + " integer primary key autoincrement, " +
            PIERCINGMAT_NAME + " string  not null);";
    //---------------------------------------------------------------------------------------------

    //------TABLE PiercingArea---------------------------------------------------------------------
    public static final String PIERCINGAREA = "PiercingArea";
    public static final String PIERCINGAREA_ID = "_ID";
    public static final String PIERCINGAREA_NAME = "_PAreaName";

    private static final String DATABASE_CREATE_PIERCINGAREA = "create table " + PIERCINGAREA +
            "(" + PIERCINGAREA_ID + " integer primary key autoincrement, " +
            PIERCINGAREA_NAME + " string  not null);";
    //---------------------------------------------------------------------------------------------

    //------TABLE TattooOrder---------------------------------------------------------------------------
/*    public static final String TATTOOORDERS = "TattooOrders";
    public static final String TATTOOORDERS_ID = "_ID";
    public static final String TATTOOORDERS_PHOTO = "_TOPhotoID";
    public static final String TATTOO_PRICE_S = "_TPriceS";
    public static final String TATTOO_PRICE_M = "_TPriceM";
    public static final String TATTOO_PRICE_L = "_TPriceL";
    public static final String TATTOO_COLOUR="_TColour";
    public static final String TATTOO_DIFFICULTY = "_TDifficulty";

    private static final String DATABASE_CREATE_TATTOOS = "create table " + TATTOOS +
            "(" + TATTOO_ID + " integer primary key autoincrement, " +
            TATTOO_PHOTO + " string  not null, " +
            TATTOO_PRICE_S + " real not null, " +
            TATTOO_PRICE_M + " real not null, " +
            TATTOO_PRICE_L + " real not null, " +
            TATTOO_COLOUR + " integer not null, " +
            TATTOO_DIFFICULTY + " integer  not null);";
*/
    //---------------------------------------------------------------------------------------------

    //------- FUNCTNS -----------------------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_PWD);
        CreateAdmins(db);

        db.execSQL(DATABASE_CREATE_TATTOOS);

        db.execSQL(DATABASE_CREATE_PIERCING);

        db.execSQL(DATABASE_CREATE_PIERCINGMAT);
        CreatePiercingMaterials(db); //adding parts in the beggining

        db.execSQL(DATABASE_CREATE_PIERCINGAREA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PWD);
        db.execSQL("DROP TABLE IF EXISTS " + TATTOOS);
        db.execSQL("DROP TABLE IF EXISTS " + PIERCING);
        db.execSQL("DROP TABLE IF EXISTS " + PIERCINGMAT);
        db.execSQL("DROP TABLE IF EXISTS " + PIERCINGAREA);

        onCreate(db);
    }

    public DataBase (Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void CreatePiercingMaterials(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(PIERCINGMAT_NAME,"Silver");
        db.insert(PIERCINGMAT,null,values);

        values=new ContentValues();
        values.put(PIERCINGMAT_NAME,"Gold");
        db.insert(PIERCINGMAT,null,values);

        values=new ContentValues();
        values.put(PIERCINGMAT_NAME,"Stainless Steel");
        db.insert(PIERCINGMAT,null,values);

        values=new ContentValues();
        values.put(PIERCINGMAT_NAME,"Other");
        db.insert(PIERCINGMAT,null,values);
    }

    public void CreateAdmins(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(ADMINNAME,"Sunay");
        values.put(ADMINNAME,"kozmi1");
        db.insert(PWD,null,values);

        values=new ContentValues();
        values.put(ADMINNAME,"Anton");
        values.put(ADMINNAME,"kozmi2");
        db.insert(PWD,null,values);

        values=new ContentValues();
        values.put(ADMINNAME,"Iskren");
        values.put(ADMINNAME,"kozmi3");
        db.insert(PWD,null,values);

    }



}
