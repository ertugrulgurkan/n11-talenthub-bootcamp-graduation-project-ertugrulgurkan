import React from "react";
import Card from "react-bootstrap/Card";

export class Credit extends React.Component {
  componentDidUpdate() {
    console.log(this.props.items);
    console.log(this.props.items.creditApplicationResult);
  }

  render() {
    return (
        <Card
          bg={
            this.props.items.creditApplicationResult === "APPROVED"
              ? "success"
              : "danger"
          }
          className="mb-2 container"
          text="white"
          style={{ width: "18rem" }}
        >
          <Card.Header>
            Credit Application Result
          </Card.Header>
          <Card.Body>
            <Card.Title>{this.props.items.creditApplicationResult}</Card.Title>
            <Card.Text>
              <b>National ID Number</b> <br />
              {this.props.items.nationalIdNumber} <br />
              <b>Credit Limit Amount</b>
              <br />
              {this.props.items.creditLimitAmount}
              <br />
              <b>Credit Application Date</b>
              <br />
              {this.props.items.applicationDate}
            </Card.Text>
          </Card.Body>
        </Card>
    );
  }
}

export default Credit;
