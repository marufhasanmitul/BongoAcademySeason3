# SQlite Database ,Insert,Read.


'''javascript 
public class SqliteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="my_database";
    public static final int DB_VERSION=1;


    public SqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table my_table(id INTEGER primary key autoincrement,name TEXT,mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists my_table");
    }

    public void insertData(String name,String mobileNumber){

        SQLiteDatabase database=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobileNumber);

        database.insert("my_table",null,contentValues);

    }

    public Cursor showAllData(){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from my_table",null);
        return cursor;
    }

    public Cursor searchById(int id){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from my_table where id like '"+id+"' ",null);
        return cursor;
    }
'''




}
