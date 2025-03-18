import { Component } from "react";

class Form extends Component{
    constructor(props)
    {
        super(props);
        this.state = {name: '', email: ''};
    }
    handleChange = (event) =>
    {
        this.setState({[event.target.name]: event.target.value});
    };

    render()
    {
        return(
            <div>
                <h2>Interactive Form</h2>
                <form>
                    <input
                    type="text"
                    name="name"
                    placeholder="Name"
                    value={this.state.name}
                    onChange={this.handleChange}
                    />
                    <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={this.state.email}
                    onChange={this.handleChange}
                    />

                </form>
                <p>Name : {this.state.name}</p>
                <p>Email : {this.state.email}</p>
            </div>
        )
    }
}

export default Form;