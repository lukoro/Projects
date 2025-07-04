using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainMenuManager : MonoBehaviour
{
    public GameObject mainMenu;
    public GameObject game;

    public void HideMainMenu()
    {
        if (mainMenu != null)
        {
            mainMenu.SetActive(false);
            game.SetActive(true);
        }

    }

    public void Quitgame()
    {
        Application.Quit();
    }
}
