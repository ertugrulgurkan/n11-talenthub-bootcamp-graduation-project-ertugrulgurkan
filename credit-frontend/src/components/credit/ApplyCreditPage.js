import React from "react";
import PageTitle from "../pageTitle/PageTitle";
import serialize from "form-serialize";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';
import CreditApplicationService from "../../api/credit/CreditApplicationService";

class ApplyCreditPage extends React.Component {
    state = {
        creditApplicationResponse: [],
        errorMessage: ''
    }

  handleFormSubmit = (e) => {
    e.preventDefault();
    const newProduct = serialize(e.target, { hash: true });

    this.save(newProduct);
  };

  save(newCreditApplication) {
    CreditApplicationService.saveCreditApplication(newCreditApplication)
      .then((response) => this.handleResponse(response))
      .catch((error) => this.handleError(error));
  }

  handleResponse(response) {
    this.setState({creditApplicationResponse: response.data})
    console.log(this.state.creditApplicationResponse)
  }

  handleError(error) {
      console.log(error)
      if(error === undefined)
        return
    this.setState({errorMessage: error.response.data.errors.join(" ")})
    console.log(error.response.data)
  }

  clearForm() {
    document.getElementById("apply-credit-form").reset();
  }


  render() {
    return (
      <>
        <PageTitle title="Apply for a Credit"></PageTitle>
        <div className="container col-md-6 offset-md-3">
          <Form
            id="apply-credit-form"
            className="mt-5"
            onSubmit={this.handleFormSubmit}
          >
            <Form.Group className="mb-3">
                <Form.Label htmlFor="nationalIdNumber">National Id Number</Form.Label>
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
                <Form.Control type="date" name="birthDate" required/>
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label htmlFor="name">Name</Form.Label>
                <Form.Control type="text" name="name" required/>
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label htmlFor="surname">Surname</Form.Label>
                <Form.Control type="text" name="surname" required/>
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label htmlFor="monthlyIncome">Monthly Income</Form.Label>
                <Form.Control  name="monthlyIncome" required />
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label htmlFor="phone">Phone</Form.Label>
                <Form.Control  name="phone" required />
              </Form.Group>
              <Form.Group className="mb-3">
                <Form.Label htmlFor="assurance">Assurance</Form.Label>
                <Form.Control  name="assurance" />
              </Form.Group>

            <Button variant="primary" type="submit">
                Apply
            </Button>
          </Form>
          {this.state.errorMessage && (
                    <Alert variant="danger" className="mb-3">
                    <Alert.Heading>Oh snap! You got an error!</Alert.Heading>
                    <p>
                    {this.state.errorMessage}
                    </p>
                  </Alert>
            )}
        </div>
      </>
    );
  }
}

export default ApplyCreditPage;
