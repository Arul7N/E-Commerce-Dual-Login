import React from "react";
import { useNavigate } from "react-router-dom";
import './style/style.css'

function ProductAdded () {
    
    const navigate = useNavigate()

    const handleAdd = () => {
        navigate('/added/new')
    }
    
    const handleHome = () => {
        navigate('/home')
    }

    return (
        <div class="custom-main">
            <div class="w-1/2 white-card flex items-center justify-between ">
                <label id="message" class="label"> Product Added Successfully...! </label>
                <div class="flex space-x-2">
                    <button onClick={handleAdd} class="green-btn">Add</button>
                    <button onClick={handleHome} class="green-btn">Home</button>
                </div>
            </div>

        </div>
    );
}

export default ProductAdded;