import React from "react";
import './style/style.css';
import './images/add_product.avif';
import { useNavigate } from "react-router-dom";


function Home () {

    const navigate = useNavigate();

    const handleAdd = () => {
        navigate('./new')
    }

    const handleView = () => {
        navigate('/home/view')
    }

    const handleEdit = () => {
        navigate('/home/edit')
    }

    const handleDelete = () => {
        navigate('/home/delete')
    }

   

    return (
        <div class="custom-main">
            <div class="w-1/3 white-card flex flex-col items-center space-x-2 justify-center">
                <div class="w-full">
                    <label htmlFor="home-label" class="text-2xl flex justify-center font-sans font-semibold text-red-700 mt-4 mb-4"> Home</label>
                    <hr class="mt-3 border-t-1 border-gray-400 mb-6 "></hr>
                </div>
                
                <div class="flex w-full gap-4 ">
                <div class="w-1/2 h-full sm:w-auto sm:flex-grow">
                    <button onClick={handleAdd} class="home-btns mb-1">Add</button>
                    <button onClick={handleEdit} class="home-btns mb-1">Edit</button>
                    <button onClick={handleDelete} class="home-btns">Delete</button>
                </div>
                <div class="flex items-center justify-center w-1/2 h-full mr-2 sm:flex sm:items-center sm:justify-between">
                    <button onClick={handleView} class="view-btn mt-1 sm:mt-0">View</button>
                </div>
                </div>
            </div>

        </div>
    )
}

export default Home;