import React from "react";
import PageTitle from "../pageTitle/PageTitle";
import serialize from "form-serialize";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Alert from "react-bootstrap/Alert";
import CreditApplicationService from "../../api/credit/CreditApplicationService";
import Credit from "./Credit";

class ShowCreditApplicationPage extends React.Component {
  state = {
    creditApplicationResponse: [],
    errorMessage: "",
    showAlert: false,
    showForm: true,
    showResult: false,
  };

  handleFormSubmit = (e) => {
    e.preventDefault();
    const data = serialize(e.target, { hash: true });

    const nationalIdNumber = data.nationalIdNumber;
    const birthDate = data.birthDate;
    //console.log(nationalIdNumber)
    //console.log(birthDate)
    this.showApplication(nationalIdNumber, birthDate);
  };

  showApplication(nationalIdNumber, birthDate) {
    CreditApplicationService.showCreditApplication(nationalIdNumber, birthDate)
      .then((response) => this.handleResponse(response))
      .catch((error) => this.handleError(error));
  }

  handleResponse(response) {
    //console.log (response)
    this.setState({
      creditApplicationResponse: response.data,
      showAlert: false,
      showForm: false,
      showResult: true,
    });
  }

  handleError(error) {
    if (error === undefined) return;
    this.setState({
      errorMessage: error.response.data.errors.join(" "),
      showAlert: true,
      showForm: true,
      showResult: false,
    });
    //console.log(error.response.data);
  }

  clearForm() {
    document.getElementById("apply-credit-form").reset();
  }

  render() {
    return (
      <>
        <PageTitle title="Show Credit Application"></PageTitle>
        <div className="container col-md-6 offset-md-3">
          {this.state.showForm ? (
            <Form
              id="apply-credit-form"
              className="mt-5"
              onSubmit={this.handleFormSubmit}
            >
              <Form.Group className="mb-3">
                <Form.Label htmlFor="nationalIdNumber">
                  National Id Number
                </Form.Label>
                <Form.Control
                  type="text"
                  name="nationalIdNumber"
                  maxLength={11}
                  minLength={11}
                  required
                />
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label htmlFor="birthDate">Birth Date</Form.Label>
                <Form.Control type="date" name="birthDate" required />
              </Form.Group>
              <Button variant="primary" type="submit">
                Apply
              </Button>
            </Form>
          ) : null}
          {this.state.errorMessage && (
            <Alert
              variant="danger"
              className="mb-3 mt-3"
              show={this.state.showAlert}
            >
              <Alert.Heading>Oh snap! You got an error!</Alert.Heading>
              <p>{this.state.errorMessage}</p>
            </Alert>
          )}
          {this.state.showResult ? (
            <Credit items={this.state.creditApplicationResponse} />
          ) : null}
        </div>
      </>
    );
  }
}

export default ShowCreditApplicationPage;
