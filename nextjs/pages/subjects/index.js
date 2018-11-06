import React from 'react'
import NavBar from '../../components/NavBar'
import SubjectList from '../../components/SubjectList';

export default class index extends React.Component {
   
    constructor(props) {
        super(props)
    }

    render() {
        return(
            <div>
                <NavBar />
                <SubjectList />
            </div>
        )
    }
}