import React from 'react'
import axios from '../util/axios'

export default class extends React.Component{
    constructor(props){
        super(props)
        this.state = {

        }
        
    }

    render(){
        return (
            <div>
                <form className="form-inline my-2 my-lg-0">
                    <input onChange={this.props.handleOnSearch} className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
                    <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        )
    }
}