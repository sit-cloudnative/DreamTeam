import React from 'react'
import NavBar from '../../components/NavBar'
import SubjectList from '../../components/SubjectList';
import axios from '../../util/axios'

export default class index extends React.Component {
   
    constructor(props) {
        super(props)
        this.state = {

        }
        this.handleOnSearch = this.handleOnSearch.bind(this)
    }

    async handleOnSearch(e){
        if(e.target.value.length > 2){
            console.log(e.target.value)
            const {data} =await axios.get('/subject-service/subjects', {
                params: {
                    keyword: e.target.value
                }
            })
            
            console.log(data)
        }  
    }

    render() {
        return(
            <div>
                <NavBar handleOnSearch={this.handleOnSearch} />
                <SubjectList />
            </div>
        )
    }
}