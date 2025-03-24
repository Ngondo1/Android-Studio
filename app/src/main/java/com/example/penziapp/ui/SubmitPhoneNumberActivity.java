import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.yourpackage.yourapp.api.ApiService;
import com.yourpackage.yourapp.api.ApiResponse;
import com.yourpackage.yourapp.api.PhoneNumberRequest;
import com.yourpackage.yourapp.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitPhoneNumberActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private Button submitButton;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_phone_number);

        phoneNumberEditText = findViewById(R.id.editTextPhoneNumber);
        submitButton = findViewById(R.id.buttonSubmit);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPhoneNumber();
            }
        });
    }

    private void submitPhoneNumber() {
        String phoneNo = phoneNumberEditText.getText().toString().trim();
        if (phoneNo.isEmpty()) {
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        PhoneNumberRequest request = new PhoneNumberRequest(phoneNo);
        Call<ApiResponse> call = apiService.submitPhoneNumber(request);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(SubmitPhoneNumberActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubmitPhoneNumberActivity.this, "Error submitting phone number", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(SubmitPhoneNumberActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
