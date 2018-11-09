import React from 'react'
import NavBar from '../../components/NavBar';
import SubjectCard from '../../components/SubjectCard'

export default class extends React.Component {
    constructor(props){
        super(props)
        this.state = {
            subjectCardList: []
        }
    }
    async componentDidMount(){
        await this.setState({
            subjectCardList: JSON.parse(localStorage.getItem('searched'))
        })
        console.log(this.state.subjectCardList)
    }

    render(){
        const subjectCardList = this.state.subjectCardList.map((subjectCard) => {
            return <SubjectCard subject={subjectCard}/>
        })
        return (
            <div>
                <NavBar />
                <div className="container">
                    <div className="row" style={{marginTop: '10px', marginBottom: '10px'}}>
                        <h2>Search Result:</h2>
                    </div>
                    <div className="row">
                        {subjectCardList}
                    </div>

                </div>

            </div>
        )
    }
}