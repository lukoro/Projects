using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Windows;

public class PlayerMovement : MonoBehaviour
{
    private Rigidbody2D body;
    [SerializeField] private float speed;
    private bool grounded;

    public GameObject mainMenu;
    public GameObject game;

    private void Awake()
    {
        body = GetComponent<Rigidbody2D>();
    }

    private void Update()
    {
        float horizontalIntput = UnityEngine.Input.GetAxis("Horizontal");
        body.velocity = new Vector2(horizontalIntput * speed,body.velocity.y);

        if (horizontalIntput > 0.1f)
        {
            transform.localScale = new Vector3((float)0.4, (float)0.4, (float)0.25);
        } else if (horizontalIntput < -0.1f)
        {
            transform.localScale = new Vector3((float)-0.4, (float)0.4, (float)0.25);
        }

        if (UnityEngine.Input.GetKey(KeyCode.W) && grounded)
        {
            Jump();
        }

        if (UnityEngine.Input.GetKey(KeyCode.Escape))
        {
            mainMenu.SetActive(true);
            game.SetActive(false);
        }

    }

    private void Jump()
    {
        body.velocity = new Vector2(body.velocity.x, speed);
        grounded = false;
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "Ground")
        {
            grounded = true;
        }

    }
}
