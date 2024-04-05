import React from "react";
import '../App.css';
import { useNavigate } from "react-router-dom";
import Icon from '../images/Arula.png'


function Header () {
    const navigate = useNavigate();

    const handleHome = () => {
        navigate("/home")
    }



    return (
        <div class="w-full h-16 px-2 text-white flex items-center justify-between top-0 bg-gray-800  border-b-2 border-red-700">
            <div class="pl-4 text-3xl"><i class="fa-brands fa-slack "></i></div>

            <div class="space-x-4 mt-8 ">
                <button onClick={handleHome} className=" hover:text-red-500  duration-300">Home</button>
                <button className="hover:text-red-500  duration-300">About</button>
                <button className="hover:text-red-500  duration-300">Contact</button>
            </div>

            <div class="text-xl pr-4"><i class="fa-regular fa-user"></i></div>
        </div>
    )
}

export default Header;