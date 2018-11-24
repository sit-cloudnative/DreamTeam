const Error404 = (props) => {
        return (
            <div>
                <div>
                    <h1>404</h1>
                </div>
                <h2>{props.errorMessage}</h2>
                <a href="/">Go To Homepage</a>
            </div >
        )
    }
export default Error404