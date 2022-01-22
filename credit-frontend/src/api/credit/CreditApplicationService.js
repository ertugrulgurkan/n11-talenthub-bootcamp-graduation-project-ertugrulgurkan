
import axios from "axios";

class CreditApplicationService{

    saveCreditApplication(newCreditApplication){
        var url = "api/v1/credit-applications";

        return axios.post(url, newCreditApplication);
    }

}

export default new CreditApplicationService();