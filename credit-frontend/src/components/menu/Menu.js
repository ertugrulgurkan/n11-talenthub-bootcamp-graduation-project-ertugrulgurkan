import React from "react";
import { Navbar, Container, Nav } from 'react-bootstrap/';


class Menu extends React.Component {

    constructor(props){
        super(props)

        this.handleLogout = this.handleLogout.bind(this);
    }

    handleLogout(){
        this.props.logout();
    }

    render() {
        return <div className="col-md-6 offset-md-3 ">
            <Navbar bg="light" expand="lg">
                <Container>
                    <Navbar.Brand href="/">Credit Center</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/add-user">Add User</Nav.Link>
                            <Nav.Link href="/update-user">Update User</Nav.Link>
                            <Nav.Link href="/delete-user">Delete User</Nav.Link>
                            <Nav.Link href="/apply-credit">Apply for a Credit</Nav.Link>
                            <Nav.Link href="/show-applications">View Applications</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>


    }
}

export default Menu;