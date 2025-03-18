import { Component } from "react";

class Data extends Component{
    constructor(props)
    {
        super(props);
        this.state = {data:null};
    }

    componentDidMount()
    {
        fetch('https://jsonplaceholder.typicode.com/posts/1')
        .then(responce => responce.json())
        .then(data => this.setState({data}));
    }

    render()
    {
        return(
            <div>
                <h2>Fetched Data</h2>
                {this.state.data ? (
                    <div>
                        <h3>{this.state.data.title}</h3>
                        <p>{this.state.data.body}</p>
                        </div>
                ) : (
                    <p>Loaading..</p>
                )}
            </div>
        );
    }
}
export default Data;