package com.cookandroid.androidapp_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cookandroid.androidapp_frontend.retrofit.UserVO;
import com.cookandroid.androidapp_frontend.retrofit.UserApi;
import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    Button btnSignIn, btnGoSignUp;
    EditText signInId, signInPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInId = (EditText)findViewById(R.id.signInId);
        signInPw = (EditText)findViewById(R.id.signInPw);

        btnGoSignUp = (Button)findViewById(R.id.btnGoSignUp);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = signInId.getText().toString();
                String pw = signInPw.getText().toString();

                UserVO loginInfo = new UserVO();
                loginInfo.setUserId(id);
                loginInfo.setuserPw(pw);

                Moshi moshi = new Moshi.Builder().build();
                // 아래 String json = moshi.adapter(User.class).indent("  ").toJson(loginInfo); 구문을 실행하면
                // 좌측 json 변수에, 위에서 loginInfo 변수에 설정된 userId, userPassword 정보를
                // User loginInfo = new User();
                // loginInfo.setUserId(id);
                // loginInfo.setUserPassword(pw);
                String json = moshi.adapter(UserVO.class).indent("  ").toJson(loginInfo);

                // 아래 System.out.println(json); 구문을 실행하면
                // 안드로이드 스튜디오 하단 "Run" 클릭했을때, 다음과 같이 화면 출력 확인이 가능합니다.
                // I/System.out: {
                // I/System.out:   "userId": "test",
                //                "userPassword": "1234"
                // }
                System.out.println(json);

                //Retrofit 객체 생성 및 MoshiConverter 추가
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.42:9008/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build();

                UserApi api = retrofit.create(UserApi.class);

                //postUser 만들어진 것 확인 ,
                Call<Boolean> call = api.postUser(loginInfo);
                call.enqueue(new Callback<Boolean>() {
                    //Controller에서 response.isSuccessful 응답 성공(또는 실패) 시 처리할 프로세스 정의
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful()){
                            boolean userExists = response.body();

                            if(userExists){
                                Intent intent = new Intent(getApplicationContext(), Page1.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.d(TAG, "Fail msg L " + t.getMessage());
                    }
                });

            }
        });

    }
}