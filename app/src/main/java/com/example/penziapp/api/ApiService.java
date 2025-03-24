import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/submit_phone_number")
    Call<ApiResponse> submitPhoneNumber(@Body PhoneNumberRequest phoneNumberRequest);
}
