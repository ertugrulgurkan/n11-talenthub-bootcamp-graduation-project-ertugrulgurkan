import axios from "axios";

class CreditApplicationService {
  saveCreditApplication(newCreditApplication) {
    var url = "api/v1/credit-applications";

    return axios.post(url, newCreditApplication);
  }

  showCreditApplication(nationalIdNumber, birthDate) {
    var url = "api/v1/credit-applications/";

    return axios.get(url, {
      params: {
        birthdate: birthDate,
        id: nationalIdNumber,
      },
    });
  }
}

export default new CreditApplicationService();
