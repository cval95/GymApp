package com.example.cormac.gym12m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Cormac on 27/04/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "gym_db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_WORKOUT = "workout_table";
    public static final String WORKOUT_ID = "_id";
    public static final String WORKOUT_NAME = "workout_name";

    public static final String TABLE_EXERCISE = "exercise_table";
    public static final String EXERCISE_ID = "exercise_id";
    public static final String EXERCISE_NAME = "exercise_name";
    public static final String EXERCISE_SET = "exercise_set";
    public static final String EXERCISE_WEIGHT = "exercise_weight";
    public static final String EXERCISE_REP = "exercise_rep";

    public static final String createWorkoutTable = "CREATE TABLE " + TABLE_WORKOUT + "("
            + WORKOUT_ID + " _id INTEGER PRIMARY KEY, "
            + WORKOUT_NAME + " TEXT NOT NULL " +
            ")";


    public static final String createExerciseTable = " CREATE TABLE " + TABLE_EXERCISE + "("
            + EXERCISE_ID + " _id INTEGER PRIMARY KEY, "
            + EXERCISE_NAME + " TEXT NOT NULL, "
            + EXERCISE_SET + " INTEGER NOT NULL, "
            + EXERCISE_WEIGHT + " INTEGER NOT NULL, "
            + EXERCISE_REP + " INTEGER NOT NULL, "
            + "FOREIGN KEY(" + WORKOUT_ID  + ") REFERENCES " + TABLE_WORKOUT + "(id)" +
            ")";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
        db.execSQL(createWorkoutTable);
        db.execSQL(createExerciseTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("DROP TABLE IF EXISTS '" + createWorkoutTable + " ' ");
        db.execSQL("DROP TABLE IF EXISTS '" + createExerciseTable + " ' ");
        onCreate(db);


    }
    //inserting in database
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user", null,contentValues);
        if (ins==1) return false;
        else return true;
    }


    //checking if the email already exists
    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }

    //checking the email and password
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if (cursor.getCount()>0) return true;
        else return false;
    }


    private static void setForeignKeyConstraintEnabled(@NonNull SQLiteDatabase db){
        if (!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=1");
        }
    }

    private static void setForeignKeyConstraintDisabled(@NonNull SQLiteDatabase db){
        if (!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=0");
        }
    }



    public void addExercise(long l, String name, String set, String weight, String reps){

        SQLiteDatabase db = this.getWritableDatabase();

        //adding exercise name in exercise table
        ContentValues cv = new ContentValues();
        cv.put(EXERCISE_NAME, name);
        cv.put(EXERCISE_SET, set);
        cv.put(EXERCISE_WEIGHT,weight);
        cv.put(EXERCISE_REP,reps);
        db.insert(TABLE_EXERCISE, null, cv);

    }


    public long addWorkout(String name){
        SQLiteDatabase db = this.getWritableDatabase();



        //adding workout name in workout table
        ContentValues values = new ContentValues();
        values.put(WORKOUT_NAME, name);
        return this.getWritableDatabase().insert(TABLE_WORKOUT,null,values);

    }

    public Cursor getWorkouts(){
        return this.getWritableDatabase().query(TABLE_WORKOUT, null,null,null,null,null,null);
    }

    public long addExercise(String name, String set, String weight, String reps){

        SQLiteDatabase db = this.getWritableDatabase();

        //adding exercise name in exercise table
        ContentValues cv = new ContentValues();
        cv.put(EXERCISE_NAME, name);
        cv.put(EXERCISE_SET, set);
        cv.put(EXERCISE_WEIGHT,weight);
        cv.put(EXERCISE_REP,reps);
        return this.getWritableDatabase().insert(TABLE_EXERCISE,null,cv);

    }

    public Cursor getWorkoutExercises(long exerciseid){
        return this.getWritableDatabase().query(TABLE_EXERCISE, null,
                EXERCISE_ID+"=?",
                new String[]{Long.toString(exerciseid)},
                null,null,null);

    }





    public Cursor getAllWorkoutsExercises(int i){

        SQLiteDatabase db = this.getReadableDatabase();

        String SELECT_QUERY = "SELECT * FROM '" + TABLE_WORKOUT  + "'JOIN'" + TABLE_EXERCISE +  "' ON '" + EXERCISE_ID  + "' GROUP BY '" + EXERCISE_ID + "'ORDER BY'" + WORKOUT_NAME + "'";
        Cursor mCursor = db.rawQuery(SELECT_QUERY, null);

        return mCursor;
    }


    public ArrayList<Workout> getAllWokouts(){
        ArrayList<Workout> workoutArrayList = new ArrayList<Workout>();
        SQLiteDatabase db = this.getReadableDatabase();

        try{
            String selectQuery = "SELECT * FROM " + TABLE_WORKOUT;
            db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            if (c != null && c.moveToFirst()){
                do {
                    Workout workout = new Workout();
                    workout.setId(c.getInt(0));
                    workout.setName(c.getString(1));

                    workoutArrayList.add(workout);


                } while (c.moveToNext());
            }

            return workoutArrayList;
        } catch (SQLiteException se){
            Log.v("Exception",
                    Log.getStackTraceString(se));

        } catch (Exception e){
            Log.v("Exception",
                    Log.getStackTraceString(e));
        } finally {
            db.close();
        }
        return workoutArrayList;
    }



    public ArrayList<Exercise> getAllExercise(){
        ArrayList<Exercise> exerciseArrayList = new ArrayList<Exercise>();
        SQLiteDatabase db = this.getReadableDatabase();

        try{
            String selectQuery = "SELECT * FROM " + TABLE_EXERCISE;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor != null && cursor.moveToFirst()){
                do {
                    Exercise exercise = new Exercise();
                    exercise.setId(cursor.getInt(0));
                    exercise.setName(cursor.getString(1));
                    exercise.setSet(cursor.getInt(2));
                    exercise.setWeight(cursor.getInt(3));
                    exercise.setReps(cursor.getInt(4));

                    exerciseArrayList.add(exercise);
                } while (cursor.moveToNext());
            }
            return exerciseArrayList;
        } catch (SQLiteException se){
            Log.v("Exception",
                    Log.getStackTraceString(se));

        } catch (Exception e){
            Log.v("Exception",
                    Log.getStackTraceString(e));
        } finally {
            db.close();
        }
        return exerciseArrayList;
    }

}




